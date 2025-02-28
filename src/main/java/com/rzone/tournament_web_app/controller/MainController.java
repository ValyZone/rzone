package com.rzone.tournament_web_app.controller;


import com.rzone.tournament_web_app.entity.User;
import com.rzone.tournament_web_app.services.blog.BlogServiceImpl;
import com.rzone.tournament_web_app.services.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.rzone.tournament_web_app.model.UserForm;

@Controller
@RequestMapping("/main")
public class MainController {

    @Autowired
    private BlogServiceImpl blogService;

    // TODO: add scoreboard injection

    @GetMapping("/")
    public String showHome(Model model) {

        model.addAttribute("latestBlog", blogService.getLatestBlog());
        return "main/home-page";
    }

    @GetMapping("/blog/latest")
    public String showLatestBlog(Model model) {

        model.addAttribute("latestBlog", blogService.getLatestBlog());
        return "main/blog/home-page";
    }

    @GetMapping("/blog/all")
    public String showAllBlogs() {

        return "main/blog/home-page";
    }

}
