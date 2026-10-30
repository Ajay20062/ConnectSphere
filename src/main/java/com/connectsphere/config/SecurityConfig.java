package com.connectsphere.config;
import com.connectsphere.service.CustomUserDetailsService;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SecurityConfig {
 @Bean PasswordEncoder passwordEncoder(){ return new BCryptPasswordEncoder(); }
 @Bean DaoAuthenticationProvider authenticationProvider(CustomUserDetailsService service, PasswordEncoder encoder){
  DaoAuthenticationProvider p=new DaoAuthenticationProvider(); p.setUserDetailsService(service); p.setPasswordEncoder(encoder); return p;
 }
 @Bean SecurityFilterChain filterChain(HttpSecurity http, DaoAuthenticationProvider provider) throws Exception {
  http.authenticationProvider(provider).authorizeHttpRequests(a->a
   .requestMatchers("/login","/register","/css/**","/js/**","/uploads/**","/ws/**").permitAll()
   .anyRequest().authenticated())
   .formLogin(f->f.loginPage("/login").defaultSuccessUrl("/",true).permitAll())
   .logout(l->l.logoutSuccessUrl("/login?logout").permitAll())
   .csrf(c->c.ignoringRequestMatchers("/ws/**"));
  return http.build();
 }
}
