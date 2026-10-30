package com.connectsphere.repository;
import com.connectsphere.entity.*; import org.springframework.data.jpa.repository.JpaRepository;
public interface FollowRepository extends JpaRepository<Follow,Long>{ boolean existsByFollowerAndFollowing(User a,User b); void deleteByFollowerAndFollowing(User a,User b); long countByFollowing(User user); long countByFollower(User user); }
