package com.connectsphere.entity;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity @Table(name="stories")
public class Story {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne private User author; private String mediaUrl; private LocalDateTime createdAt=LocalDateTime.now();
 public Long getId(){return id;} public User getAuthor(){return author;} public void setAuthor(User v){author=v;}
 public String getMediaUrl(){return mediaUrl;} public void setMediaUrl(String v){mediaUrl=v;}
 public LocalDateTime getCreatedAt(){return createdAt;}
}
