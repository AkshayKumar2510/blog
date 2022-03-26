package com.akki.springboot.projectBlog.controller;

import com.akki.springboot.projectBlog.model.Comments;
import com.akki.springboot.projectBlog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/post/view/{posts}/{postId}")
public class CommentController {
    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/commentLists")
    public String viewComments(Model model){
        List<Comments> commentList = commentService.findAll();
        System.out.println("Comment Data- " + commentList);
        model.addAttribute("commentList", commentList);
        return "posts/searchResult";
    }

    /*@RequestMapping("/showCommentForm")
    public String showCommentForm(Model model){
        Comments comments = new Comments();

        model.addAttribute("comments", comments);
        return "posts/searchResult";
    }

    @RequestMapping("/showCommentFormForUpdate")
    public String showCommentFormForUpdate(@RequestParam("commentId") int id, Model model){

        Comments comments = commentService.findCommentsById(id);

        model.addAttribute("comments", comments);
        return "posts/searchResult";
    }
*/
    @PostMapping("/saveComment")
    public String saveComment(@ModelAttribute Comments comments, Model model){
        //save comments
        System.out.println("comments: " + comments);

        commentService.save(comments);
        return "redirect:/commentLists";
    }


    @PostMapping("/delete")
    public String delete(@RequestParam("commentId") int id, Model model){
        commentService.deleteById(id);
        return "redirect:/commentLists";
    }
}
