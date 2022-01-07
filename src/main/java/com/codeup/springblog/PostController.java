package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class PostController {
    private final PostRepository postDao;

    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao){
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping("/posts")
    public String postIndex(Model model){
        model.addAttribute("posts", postDao.findAll());

        return "posts/index";
    }

    @GetMapping("/posts/{id}")

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

    //This portion is necessary in order to save the changes made in the edits
    @PostMapping("/posts/edit/{id}")
    public String editPost(@PathVariable Long id, @RequestParam(name="postTitle") String title, @RequestParam(name="postBody") String body){
        Post post = postDao.getById(id);
        post.setTitle(title);
        post.setBody(body);
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/show/{id}")
    public String showPost(@PathVariable Long id, Model model){

        Post post = postDao.getById(id);
        User user = userDao.getById(13L);
        model.addAttribute("post", post);
        model.addAttribute("user", user);

        return "posts/show";
    }


    @GetMapping("/posts/create")
    public String viewPostForm(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@RequestParam(name="createPostTitle") String title, @RequestParam(name="createPostBody") String body){
        Post post = new Post();
       post.setUser(userDao.getById(1L));
       post.setTitle(title);
       post.setBody(body);
        postDao.save(post);

        return "redirect:/posts";
    }

}


