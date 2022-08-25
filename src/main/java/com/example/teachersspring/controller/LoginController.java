package com.example.teachersspring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String doGet() {
        return "login";
    }

    @PostMapping("/login")
    public String handleForm(@RequestParam("eMail") String email, @RequestParam("password") String password, Model model) {
        // DTO construction
        
        if (email.equals("dummyEmail@gmail.com") & password.equals("123")){
            return "teachersmenu";
        } else {
            model.addAttribute("error", true);
            return "login";
        }

    }
}
