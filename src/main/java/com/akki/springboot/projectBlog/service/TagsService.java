package com.akki.springboot.projectBlog.service;

import com.akki.springboot.projectBlog.model.Tags;

import java.util.List;

public interface TagsService {
    public List<Tags> findAllTags();
    public Tags findByTagId(int tagId);
    public void save(Tags tags);
    public void deleteByTagId(int tagId);
}
