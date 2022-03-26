package com.akki.springboot.projectBlog.service;

import com.akki.springboot.projectBlog.dao.TagsRepository;
import com.akki.springboot.projectBlog.model.Posts;
import com.akki.springboot.projectBlog.model.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagsServiceImplementation implements TagsService {

    private TagsRepository tagsRepository;

    @Autowired
    public TagsServiceImplementation(TagsRepository tagsRepository) {
        this.tagsRepository = tagsRepository;
    }

    @Override
    public List<Tags> findAllTags() {
        return tagsRepository.findAll();
    }

    @Override
    public Tags findByTagId(int tagId) {
        Optional<Tags> result = tagsRepository.findById(tagId);
        Tags tags = null;
        if(result.isPresent()){
            tags = result.get();
        }else{
            throw new RuntimeException("Tag id is unavailable " + tagId);
        }
        return tags;
    }

    @Override
    public void save(Tags tags) {
        tagsRepository.save(tags);
    }

    @Override
    public void deleteByTagId(int tagId) {
        tagsRepository.deleteById(tagId);
    }

}
