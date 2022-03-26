package com.akki.springboot.projectBlog.service;

import com.akki.springboot.projectBlog.dao.PostsRepository;
import com.akki.springboot.projectBlog.model.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImplementation implements PostService{

    private PostsRepository postsRepository;

    @Autowired
    public PostServiceImplementation(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    @Override
    public List<Posts> findAllPosts() {
        return postsRepository.findAll();
    }

    @Override
    public Posts findPostsById(int postId) {
        Optional<Posts> result = postsRepository.findById(postId);

        Posts posts = null;
        if(result.isPresent()){
            posts = result.get();
        }else {
            throw new RuntimeException("Post id not available- " + postId);
        }
        return posts;
    }

    @Override
    public void save(Posts posts) {
        Optional<Posts> savedPost = postsRepository.findById(posts.getId());
        if( savedPost.isEmpty()){
            posts.setUpdateTime(null);
            posts.setCreationTime(LocalDateTime.now());
        }else{
            posts.setUpdateTime(LocalDateTime.now());
            posts.setCreationTime(savedPost.get().getCreationTime());
        }
        posts.setPublishTime(LocalDateTime.now());
        posts.setPublished(true);
        postsRepository.save(posts);
    }

    @Override
    public void deleteById(int postId) {
        postsRepository.deleteById(postId);
    }

    @Override
    public List<Posts> search(String searching) {
        return postsRepository.findByText(searching.toLowerCase());
    }

}