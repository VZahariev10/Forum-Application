package com.example.forum.repositories;

import com.example.forum.model.Post;

import java.util.List;

public interface PostDao {
    void createPost(Post post);

    List<Post> getAllPosts();

    Post getPostById(int id, Post post);

    void updatePostById(int id, Post post);

    void deletePostById(int id, Post post);
}
