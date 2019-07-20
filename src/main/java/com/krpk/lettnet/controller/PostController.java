package com.krpk.lettnet.controller;

import com.krpk.lettnet.domain.Post;
import com.krpk.lettnet.domain.User;
import com.krpk.lettnet.repo.PostRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    private final PostRepo postRepo;

    public PostController(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    @GetMapping("{id}")
    public List<Post> getPosts(@PathVariable String id){
        return postRepo.findByAuthorId(id);
    }

    @PostMapping
    public Post createPost(
            @AuthenticationPrincipal User user,
            @RequestBody Post post
    ){
        post.setAuthor(user);
        post.setPublicationDate(LocalDateTime.now());
        return postRepo.save(post);
    }

    @PutMapping("{id}")
    public Post updatePost(
            @PathVariable("id") Post postFromDb,
            @RequestBody Post post
    ) {
        BeanUtils.copyProperties(post, postFromDb, "id");
        return postRepo.save(postFromDb);
    }

    @DeleteMapping("{id}")
    public void deletePost (@PathVariable("id") Post post) {
        postRepo.delete(post);
    }

}
