package com.akki.springboot.projectBlog.service;

import com.akki.springboot.projectBlog.model.Posts;

import java.util.List;

public interface PostService {

    List<Posts> findAllPosts();
    Posts findPostsById(int id);
    void save(Posts posts);
    void deleteById(int postId);
    List<Posts> search(String searching);
}