package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

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



//    @GetMapping("/posts")
//    public String postIndex(Model model){
//
//        ArrayList<Post> allPosts = new ArrayList<>();
//        Post testPost1 = new Post();
//        testPost1.setTitle("Test Post");
//        testPost1.setBody("This is a test of the body");
//        allPosts.add(testPost1);
//
//        Post testPost2 = new Post();
//        testPost2.setTitle("Test Post 2");
//        testPost2.setBody("This is a test of the body");
//        allPosts.add(testPost2);
//        model.addAttribute("allPosts", allPosts);
//        return "posts/index";
//    }
//
//    @GetMapping("/posts/{id}")
//    public String individualPost(@PathVariable int id, Model model){
//        Post testPost = new Post();
//        testPost.setTitle("Test Post");
//        testPost.setBody("This is a test of the body");
//        model.addAttribute("testPost", testPost);
//
//        return "posts/show";
//    }

    @GetMapping("/posts/create")
    public String viewPostForm(){
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    public String createPost(){
        return "create a new post";
    }

}
