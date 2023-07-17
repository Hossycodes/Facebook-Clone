package com.facebook.facebookmini.controller;

import com.facebook.facebookmini.entity.AppUser;
import com.facebook.facebookmini.entity.Post;
import com.facebook.facebookmini.repository.UserRepository;
import com.facebook.facebookmini.service.PostService;
import com.facebook.facebookmini.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path ="api/facebook")
public class AppUserController {
    private final UserService userService;
    private final UserRepository userRepository;
    private final PostService postService;

    public AppUserController(UserService userService, UserRepository userRepository, PostService postService) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.postService = postService;
    }



    @GetMapping("/login")
    public String welcomePage(Model model) {
        model.addAttribute("appUser", new AppUser());
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute("appUser") AppUser appUser, HttpServletRequest request, Model model) {
        Optional<AppUser> optionalAppUser = userService.LoginAppUser(appUser.getEmail(), appUser.getPassword());
        if (optionalAppUser.isPresent()) {
            AppUser user = optionalAppUser.get();
            HttpSession session = request.getSession();
            session.setAttribute("appUser", user);
            return "redirect:/api/facebook/home";
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }
    }




    @RequestMapping (method = RequestMethod.POST,path ="/signup")
    public String displaySignUpPage(@ModelAttribute("appUser") AppUser appUser){
       userService.SignUpAppUser(appUser);
       return "login";
    }
    @GetMapping("/signup")
    public String signUp(Model model){
        model.addAttribute("appUser", new AppUser());

        return "signup";
    }

    @GetMapping("/home")
    public String showHomePage(Model model, HttpServletRequest request) {
// Get the authenticated user from the session
        System.out.println("Home page");
        HttpSession session = request.getSession();
        AppUser user = (AppUser) session.getAttribute("appUser");
        System.out.println("my user " + user);
        List<Post> posts = postService.getAllPosts();


// Check if the user is logged in
        if (user != null) {
// Add the user's name to the model
            model.addAttribute("userName", user.getFirstName() + " " + user.getLastName());
            model.addAttribute("posts", posts);

// Return the homepage template
            return "home";
        } else {
// If the user is not logged in, redirect to the login page
            return "redirect:/api/facebook/signup";
        }
    }


}
