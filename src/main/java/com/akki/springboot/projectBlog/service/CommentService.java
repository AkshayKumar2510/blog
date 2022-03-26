package com.akki.springboot.projectBlog.service;

import com.akki.springboot.projectBlog.model.Comments;

import java.util.List;

public interface CommentService {

    public List<Comments> findAll();
    public Comments findCommentsById(int id);
    public void save(Comments comments);
    public void deleteById(int commentId);
}
