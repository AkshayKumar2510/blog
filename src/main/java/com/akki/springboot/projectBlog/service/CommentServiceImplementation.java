package com.akki.springboot.projectBlog.service;

import com.akki.springboot.projectBlog.dao.CommentsRepository;
import com.akki.springboot.projectBlog.model.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImplementation implements CommentService {

    private CommentsRepository commentsRepository;

    @Autowired
    public CommentServiceImplementation(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    @Override
    public List<Comments> findAll() {
        return commentsRepository.findAll();
    }

    @Override
    public Comments findCommentsById(int commentId) {
        Optional<Comments> result = commentsRepository.findById(commentId);

        Comments comments = null;
        if(result.isPresent()){
            comments = result.get();
        }else {
            throw new RuntimeException("Comment id unavailable " + commentId);
        }
        return comments;
    }

    @Override
    public void save(Comments comments) {
        if(comments.getCreationTime() == null){
            comments.setCreationTime(LocalDateTime.now());
        }else{
            comments.setUpdateTime(LocalDateTime.now());
        }
        commentsRepository.save(comments);
    }

    @Override
    public void deleteById(int commentId) {
        commentsRepository.deleteById(commentId);
    }
}
