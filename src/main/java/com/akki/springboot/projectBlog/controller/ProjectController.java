package com.akki.springboot.projectBlog.controller;

import com.akki.springboot.projectBlog.model.Posts;
import com.akki.springboot.projectBlog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/post")
public class ProjectController {
    private PostService postService;

    @Autowired
    public ProjectController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String getListData(Model model){
        List<Posts> postData = postService.findAllPosts();
        model.addAttribute("postLists", postData);
        return "posts/listPost";
    }

    @GetMapping("/showPostForm")
    public String showPostForm(Model model){
        Posts posts = new Posts();

        model.addAttribute("postForm", posts);
        return "posts/postForm";
    }

    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("postId") int id, Model model){

        Posts posts = postService.findPostsById(id);

        model.addAttribute("postForm", posts);
        return "posts/postForm";
    }
    @PostMapping("/savePost")
    public String savePost(@ModelAttribute("postForm") Posts posts){
        postService.save(posts);
        return "redirect:/post/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("postId") int id, Model model){
        postService.deleteById(id);
        return "redirect:/post/";
    }

    @GetMapping("/search")
    public String searchByAuthor(@RequestParam("searching") String searching, Model model){
        List<Posts> postList = postService.search(searching);
        model.addAttribute("searchList", postList);
        return "posts/searchResult";
    }

    /*@GetMapping("/sortDate/{dateAsc}")
    public String sortDate(@RequestParam("dateAsc") String dateAsc, Model model){
        List<Posts> sortedDate = postService.sort(dateAsc);
        model.addAttribute("sortDateList", sortedDate);
        return "redirect:/post/";
    }*/

    /*@GetMapping("/fetch")
    public String fetchTags(){
        return "";
    }*/


    @GetMapping("/view/{postId}")
    public String viewPost(@PathVariable int postId, Model model){
        Posts posts = postService.findPostsById(postId);
        model.addAttribute("posts",posts);
        //model.addAttribute("comments", comments);
        return "posts/searchResult";
    }

    /*@RequestMapping("/mapping")
    public String controlMapping(){

        return "redirect:/";
    }*/
}