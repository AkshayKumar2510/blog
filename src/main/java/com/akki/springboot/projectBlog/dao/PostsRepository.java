package com.akki.springboot.projectBlog.dao;

import com.akki.springboot.projectBlog.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Integer> {

    @Query(
            value = "select * from Posts p where lower(p.title || p.author || p.content) like %?1%",
            nativeQuery = true
    ) List<Posts> findByText(String title);

/*    @Query(
            value = "select p.content, p.created_at from Posts p",
            nativeQuery = true)
    List<Posts> fetchTags();*/
    List<Posts> findAllByOrderByAuthorAsc();
    List<Posts> findAllByOrderByPublishTimeAsc();
    //public List<Posts> findAllByNameOrAuthor(String author);
}