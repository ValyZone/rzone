package com.rzone.tournament_web_app.controller;


import com.rzone.tournament_web_app.entity.User;
import com.rzone.tournament_web_app.services.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.rzone.tournament_web_app.model.UserForm;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/")
    public String showHome() {

        return "home/home-page";
    }

    @GetMapping("/login")
    public String showLogin(Model model) {

        model.addAttribute("userForm", new UserForm());

        return "home/login-page";
    }

    @PostMapping("/process-login")
    public String processLogin(UserForm userForm) {

        User existingUser = userService.findByUsername(userForm.getUsername());

        if (existingUser == null) {
            System.out.println("No such user: " + userForm.getUsername());

            return "redirect:/home/failed";
        } else {
            System.out.println("userForm pass: " + userForm.getPassword() + ". existingUser pass: " + existingUser.getPassword());

            if ( existingUser.getPassword().equals(userForm.getPassword()) ) {
                System.out.println("User does exist.");

                return "redirect:/admin/home";
            }
            else {
                System.out.println("Incorrect password.");
                return "redirect:/home/failed";
            }
        }
    }

    @GetMapping("/register")
    public String showRegister(Model model) {

        model.addAttribute("userForm", new UserForm());

        return "home/register-page";
    }

    @PostMapping("/process-register")
    public String processRegister(UserForm userForm) {
        // Check if user already exists
        User existingUser = userService.findByUsername(userForm.getUsername());

        if (existingUser == null) {
            // Save new user
            User newUser = new User(userForm.getUsername(), userForm.getPassword());
            userService.save(newUser);
            System.out.println("New user registered: " + userForm.getUsername());
            return "redirect:/home/";
        } else {
            System.out.println("User already exists: " + userForm.getUsername());
            return "redirect:/home/failed";
        }
    }

    @GetMapping("/failed")
    public String showFailure() {

        return "home/failed-page.html";
    }

}
