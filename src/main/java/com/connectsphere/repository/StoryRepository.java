package com.connectsphere.repository;
import com.connectsphere.entity.Story; import org.springframework.data.jpa.repository.JpaRepository; import java.time.LocalDateTime; import java.util.*;
public interface StoryRepository extends JpaRepository<Story,Long>{ List<Story> findByCreatedAtAfterOrderByCreatedAtDesc(LocalDateTime time); }
