package com.example.forum.repositories;

import com.example.forum.model.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository implements PostDao {
    private final List<Post> posts;

    public PostRepository(List<Post> posts) {
        this.posts = new ArrayList<>();
    }

    @Override
    public void createPost(Post post) {
        this.posts.add(new Post(posts.size() + 1,
                post.getTitle(),
                post.getContent(),
                post.getUserId()));
    }

    @Override
    public List<Post> getAllPosts() {
        return posts;
    }

    @Override
    public Post getPostById(int id, Post post) {
        for (Post post1 : posts) {
            if (post1.getId() == id) {
                post = post1;
            }
        }
        return post;
    }

    @Override
    public void updatePostById(int id, Post post) {
        post.setId(id);
        for (Post post1 : posts) {
            if(post1.getId() == id){
                post1.setTitle(post.getTitle());
                post1.setContent(post.getContent());
                post1.setUserId(post.getUserId());
            }
        }
    }

    @Override
    public void deletePostById(int id, Post post) {
        for (Post post1 : posts) {
            if (post1.getId() == id) {
                post = post1;
            }
        }
        posts.remove(post);
    }
}
