package com.krpk.lettnet.repo;

import com.krpk.lettnet.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {
    List<Post> findByAuthorId(String userId);
}
