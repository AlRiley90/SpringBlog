package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class PostController {
    private final PostRepository postDao;

    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String postIndex(Model model){
        model.addAttribute("posts", postDao.findAll());

//        model.addAttribute("titles", postDao.findAllByTitle());
        return "posts/index";
    }

    @PostMapping("/posts/index")
    public String deletePost(@RequestParam(name="deletePost") Long id, Model model){
        System.out.println("id = " + id);
        postDao.deleteById(id);
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }
    @GetMapping("/posts/edit/{id}")
    public String viewPostToEdit(@PathVariable Long id, Model model){
        model.addAttribute("title", "Edit Post");
        Optional<Post> currentPost = postDao.findById(id);
        Post post = currentPost.get();
        model.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("/posts/edit/{id}")
    public String editPost(@PathVariable Long id, @RequestParam String title, @RequestParam String body){
        Post post = postDao.getById(id);
        post.setTitle(title);
        post.setBody(body);
        postDao.save(post);
        return "redirect:/posts";
    }



    @GetMapping("/posts/{id}")
    public String editIndividualPost(@PathVariable Long id, Model model){
        Post testPost = new Post();
        testPost.setTitle("Test Post");
        testPost.setBody("This is a test of the body");
        model.addAttribute("testPost", testPost);

        postDao.findById(id);

        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String viewPostForm(){
        return "this is the create page";
    }

    @PostMapping("/posts/create")
    public String createPost(){
        return "create a new post";
    }

}


