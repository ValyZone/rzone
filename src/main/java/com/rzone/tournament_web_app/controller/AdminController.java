package com.rzone.tournament_web_app.controller;

import com.rzone.tournament_web_app.dao.BlogRepository;
import com.rzone.tournament_web_app.entity.BlogPost;
import com.rzone.tournament_web_app.model.BlogForm;
import com.rzone.tournament_web_app.services.blog.BlogService;
import com.rzone.tournament_web_app.services.blog.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private BlogServiceImpl blogService;

    @GetMapping("/home")
    public String showAdminHome() {
        return "admin/home-page";
    }

    @GetMapping("/createblog")
    public String showBlogForm(Model model) {
        model.addAttribute("blogForm", new BlogForm());
        return "admin/blog-publish-page";
    }

    @PostMapping("/process-createBlog")
    public String saveBlogPost(@ModelAttribute BlogForm blogForm, RedirectAttributes redirectAttributes) {

        BlogPost theBlog = new BlogPost(blogForm.getTitle(), blogForm.getContent());
        blogService.save(theBlog);

        redirectAttributes.addFlashAttribute("blogCreated", true);

        return "redirect:/admin/home";
    }

    @PostMapping("/blog/upload")
    public String uploadMarkdownFile(@RequestParam("file") MultipartFile file) throws IOException {
        String content = new String(file.getBytes(), StandardCharsets.UTF_8);
        BlogPost blogPost = new BlogPost();
        blogPost.setTitle(file.getOriginalFilename());
        blogPost.setContent(content);
        blogService.save(blogPost);
        return "redirect:/admin/admin-page";
    }
}

