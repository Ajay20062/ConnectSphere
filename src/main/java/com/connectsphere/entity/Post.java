package com.connectsphere.entity;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity @Table(name="posts")
public class Post {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) private User author;
 @Column(length=2000) private String caption;
 private String mediaUrl; private String mediaType="IMAGE";
 private LocalDateTime createdAt=LocalDateTime.now();
 public Long getId(){return id;} public User getAuthor(){return author;} public void setAuthor(User v){author=v;}
 public String getCaption(){return caption;} public void setCaption(String v){caption=v;}
 public String getMediaUrl(){return mediaUrl;} public void setMediaUrl(String v){mediaUrl=v;}
 public String getMediaType(){return mediaType;} public void setMediaType(String v){mediaType=v;}
 public LocalDateTime getCreatedAt(){return createdAt;}
}
