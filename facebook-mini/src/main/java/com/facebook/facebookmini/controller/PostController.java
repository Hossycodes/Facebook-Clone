package com.facebook.facebookmini.controller;


import com.facebook.facebookmini.entity.AppUser;
import com.facebook.facebookmini.entity.Post;
import com.facebook.facebookmini.repository.PostRepository;
import com.facebook.facebookmini.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final PostRepository postRepository;

    @GetMapping("/create_post")
    public String showCreatePostForm(Model model) {
        model.addAttribute("post", new Post()); // Add the "post" model attribute
        return "create_post";
    }


    @PostMapping("/create_post")
    public String createPost(@RequestParam("content") String content, HttpSession session) {
// Get the authenticated user from the session
        System.out.println("oh mehn!");
// HttpSession session = request.getSession();
// System.out.println("this is the " + session.getAttribute("appuser") );
        AppUser user = (AppUser) session.getAttribute("appUser");
        System.out.println("this is the " + user.getFirstName()+user.getFirstName());


// Create a new Post object
        Post post = new Post();
        post.setAppUser(user);
        post.setContent(content);
        post.setTimeStamp(LocalDateTime.now());

// Save the post using the PostService
        postService.createPost(post);
        System.out.println("Chai!, there's God oo");

        return "redirect:/api/facebook/home";
    }

    // @GetMapping("/posts")
// public String viewAllPosts(Model model) {
// List<Post> posts = postRepository.findAll();
// model.addAttribute("posts", posts);
// model.addAttribute("comment", new Comment());
// return "all_post";
// }
    @GetMapping("/all_post")
    public String viewAllPosts(Model model) {
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
// model.addAttribute("comment", new Comment());
        return "all_post";
    }

    @PostMapping("/update_post")
    public String updatePost(@RequestParam("postId") Long postId, @RequestParam("content") String content) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));

        post.setContent(content);
        postService.updatePost(post);

        return "redirect:/api/facebook/home";
    }

    @PostMapping("/delete_post")
    public String deletePost(@RequestParam("postId") Long postId) {
        postService.deletePost(postId);

        return "redirect:/api/facebook/home";
    }



}