package com.connectsphere.repository;
import com.connectsphere.entity.*; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface PostRepository extends JpaRepository<Post,Long>{ List<Post> findAllByOrderByCreatedAtDesc(); List<Post> findByAuthorOrderByCreatedAtDesc(User user); }
