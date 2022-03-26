package com.akki.springboot.projectBlog.controller;

import com.akki.springboot.projectBlog.model.Tags;
import com.akki.springboot.projectBlog.service.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/tags")
public class TagsController {
    private TagsService tagsService;

    @Autowired
    public TagsController(TagsService tagsService) {
        this.tagsService = tagsService;
    }

    @GetMapping("/showTags")
    public String viewTags(Model model){
        List<Tags> tagList = tagsService.findAllTags();
        System.out.println("Tags: " + tagList);
        model.addAttribute("tagList", tagList);
        return "tagPage";
    }
}
