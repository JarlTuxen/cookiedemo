package com.example.cookiedemo.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class homeController {

    //inject HttpSession i metode
    @GetMapping("/")
    public String showIndex(HttpSession session, Model model){
        //hvis username ikke er sat, så rediriger til login
        if (session.getAttribute("username") == null){
            return "redirect:/login";
        }
        return "index";
    }

    @GetMapping("/login")
    public String showLogin(){
        return "login";
    }

    //inject HttpSession
    @PostMapping("/login")
    public String doLogin(@RequestParam("username") String user, HttpSession session){
        //set username attribut i session
        session.setAttribute("username", user);
        return "redirect:/";
    }
}













