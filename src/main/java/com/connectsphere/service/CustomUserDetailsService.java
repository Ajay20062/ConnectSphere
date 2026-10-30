package com.connectsphere.service;
import com.connectsphere.repository.UserRepository; import org.springframework.security.core.userdetails.*; import org.springframework.stereotype.Service;
@Service
public class CustomUserDetailsService implements UserDetailsService {
 private final UserRepository users; public CustomUserDetailsService(UserRepository u){users=u;}
 public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
  var u=users.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User not found"));
  return User.withUsername(u.getUsername()).password(u.getPassword()).roles(u.getRole()).build();
 }
}
