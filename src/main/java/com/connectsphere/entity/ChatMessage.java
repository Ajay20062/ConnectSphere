package com.connectsphere.entity;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity @Table(name="messages")
public class ChatMessage {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 private String sender; private String content; private LocalDateTime sentAt=LocalDateTime.now();
 public Long getId(){return id;} public String getSender(){return sender;} public void setSender(String v){sender=v;}
 public String getContent(){return content;} public void setContent(String v){content=v;}
 public LocalDateTime getSentAt(){return sentAt;}
}
