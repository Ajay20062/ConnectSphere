package com.connectsphere.controller;
import com.connectsphere.repository.*; import com.connectsphere.entity.*; import com.connectsphere.service.FileStorageService;
import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.web.bind.annotation.*; import org.springframework.web.multipart.MultipartFile;
import java.security.Principal; import java.time.LocalDateTime;
@Controller
public class HomeController {
 private final UserRepository users; private final PostRepository posts; private final FollowRepository follows; private final StoryRepository stories; private final CommunityRepository communities; private final FileStorageService storage;
 public HomeController(UserRepository u,PostRepository p,FollowRepository f,StoryRepository s,CommunityRepository c,FileStorageService fs){users=u;posts=p;follows=f;stories=s;communities=c;storage=fs;}
 private User me(Principal p){return users.findByUsername(p.getName()).orElseThrow();}
 @GetMapping("/") public String home(Model m,Principal p){m.addAttribute("me",me(p));m.addAttribute("posts",posts.findAllByOrderByCreatedAtDesc());m.addAttribute("stories",stories.findByCreatedAtAfterOrderByCreatedAtDesc(LocalDateTime.now().minusHours(24)));m.addAttribute("communities",communities.findAll());return "home";}
 @PostMapping("/posts") public String post(@RequestParam String caption,@RequestParam(required=false) MultipartFile media,Principal p) throws Exception {Post x=new Post();x.setAuthor(me(p));x.setCaption(caption);x.setMediaUrl(storage.save(media));if(media!=null&&!media.isEmpty())x.setMediaType(media.getContentType()!=null&&media.getContentType().startsWith("video")?"VIDEO":"IMAGE");posts.save(x);return "redirect:/";}
 @GetMapping("/profile/{username}") public String profile(@PathVariable String username,Model m,Principal p){User u=users.findByUsername(username).orElseThrow();m.addAttribute("profile",u);m.addAttribute("me",me(p));m.addAttribute("posts",posts.findByAuthorOrderByCreatedAtDesc(u));m.addAttribute("followers",follows.countByFollowing(u));m.addAttribute("following",follows.countByFollower(u));m.addAttribute("isFollowing",follows.existsByFollowerAndFollowing(me(p),u));return "profile";}
 @PostMapping("/follow/{id}") public String follow(@PathVariable Long id,Principal p){User a=me(p),b=users.findById(id).orElseThrow();if(!a.getId().equals(b.getId())){if(follows.existsByFollowerAndFollowing(a,b))follows.deleteByFollowerAndFollowing(a,b);else follows.save(new Follow(a,b));}return "redirect:/profile/"+b.getUsername();}
 @GetMapping("/search") public String search(@RequestParam(defaultValue="") String q,Model m,Principal p){m.addAttribute("q",q);m.addAttribute("results",users.findByUsernameContainingIgnoreCaseOrFullNameContainingIgnoreCase(q,q));m.addAttribute("me",me(p));return "search";}
 @PostMapping("/stories") public String story(@RequestParam MultipartFile media,Principal p)throws Exception{Story s=new Story();s.setAuthor(me(p));s.setMediaUrl(storage.save(media));stories.save(s);return "redirect:/";}
 @PostMapping("/communities") public String community(@RequestParam String name,@RequestParam String description,Principal p){Community c=new Community();c.setName(name);c.setDescription(description);c.setCreator(me(p));communities.save(c);return "redirect:/";}
 @GetMapping("/messages") public String messages(Model m,Principal p){m.addAttribute("me",me(p));return "messages";}
}
