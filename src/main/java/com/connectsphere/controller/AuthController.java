package com.connectsphere.controller;
import com.connectsphere.entity.User; import com.connectsphere.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder; import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.web.bind.annotation.*;
@Controller
public class AuthController {
 private final UserRepository users; private final PasswordEncoder encoder;
 public AuthController(UserRepository u,PasswordEncoder e){users=u;encoder=e;}
 @GetMapping("/login") public String login(){return "login";}
 @GetMapping("/register") public String register(){return "register";}
 @PostMapping("/register") public String create(@RequestParam String username,@RequestParam String email,@RequestParam String password,@RequestParam(required=false) String fullName,Model model){
  if(users.findByUsername(username).isPresent()||users.findByEmail(email).isPresent()){model.addAttribute("error","Username or email already exists");return "register";}
  User u=new User();u.setUsername(username);u.setEmail(email);u.setPassword(encoder.encode(password));u.setFullName(fullName);users.save(u);return "redirect:/login?registered";
 }
}
