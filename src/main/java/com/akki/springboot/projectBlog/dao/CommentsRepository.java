package com.akki.springboot.projectBlog.dao;

import com.akki.springboot.projectBlog.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments, Integer> {
}
