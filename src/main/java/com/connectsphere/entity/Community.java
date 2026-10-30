package com.connectsphere.entity;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity @Table(name="communities")
public class Community {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,unique=true) private String name; private String description;
 @ManyToOne private User creator; private LocalDateTime createdAt=LocalDateTime.now();
 public Long getId(){return id;} public String getName(){return name;} public void setName(String v){name=v;}
 public String getDescription(){return description;} public void setDescription(String v){description=v;}
 public User getCreator(){return creator;} public void setCreator(User v){creator=v;}
}
