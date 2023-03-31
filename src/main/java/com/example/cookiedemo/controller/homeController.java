package com.example.cookiedemo.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class homeController {

    //inject Session i metode
    @GetMapping("/")
    public String showIndex(HttpSession session, Model model){
        if (session.getAttribute("username") == null){
            return "redirect:/login";
        }
        return "index";
    }

    @GetMapping("/login")
    public String showLogin(){
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam("username") String user, HttpSession session){
        session.setAttribute("username", user);
        return "redirect:/";
    }
}













