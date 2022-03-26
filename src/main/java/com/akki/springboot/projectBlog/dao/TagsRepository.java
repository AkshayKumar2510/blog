package com.akki.springboot.projectBlog.dao;

import com.akki.springboot.projectBlog.model.Tags;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagsRepository extends JpaRepository<Tags, Integer> {

}
