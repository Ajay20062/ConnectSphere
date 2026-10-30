package com.connectsphere.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity @Table(name="users")
public class User {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,unique=true) private String username;
 @Column(nullable=false,unique=true) private String email;
 @Column(nullable=false) private String password;
 private String fullName; private String bio; private String profileImage;
 private String role="USER"; private LocalDateTime createdAt=LocalDateTime.now();
 public Long getId(){return id;} public String getUsername(){return username;} public void setUsername(String v){username=v;}
 public String getEmail(){return email;} public void setEmail(String v){email=v;}
 public String getPassword(){return password;} public void setPassword(String v){password=v;}
 public String getFullName(){return fullName;} public void setFullName(String v){fullName=v;}
 public String getBio(){return bio;} public void setBio(String v){bio=v;}
 public String getProfileImage(){return profileImage;} public void setProfileImage(String v){profileImage=v;}
 public String getRole(){return role;} public void setRole(String v){role=v;}
 public LocalDateTime getCreatedAt(){return createdAt;}
}
