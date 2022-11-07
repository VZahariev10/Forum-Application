package com.example.forum.controller;

import com.example.forum.model.Post;
import com.example.forum.repositories.PostDao;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostDao postDao;


    @GetMapping("/posts/getAll")
    public List<Post> getAllPosts(){
        return postDao.getAllPosts();
    }

    @GetMapping("posts/getByID/{id}")
    public Post getPostById(@PathVariable int id, @RequestBody Post post){
        return postDao.getPostById(id, post);
    }
    @PostMapping("/posts/create")
    public void createPost(@RequestBody Post post){
        postDao.createPost(post);
    }
    @PutMapping("/posts/updateByID/{id}")
    public void updatePostById(@PathVariable int id, @RequestBody Post post){
        postDao.updatePostById(id, post);
    }
    @DeleteMapping("/posts/deleteByID/{id}")
    public void deletePostById(@PathVariable int id, @RequestBody Post post){
        postDao.deletePostById(id, post);
    }
}
