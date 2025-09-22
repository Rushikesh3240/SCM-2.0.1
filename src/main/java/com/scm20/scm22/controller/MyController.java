package com.scm20.scm22.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @RequestMapping("/home")
    public String homeController(){
        return "home";
    }

    @RequestMapping("/service")
    public String service(){
        return "service";
    }

    @RequestMapping("/about")
    public String about(Model model){
        model.addAttribute("isLogin", true);
        return "about";
    }

    @RequestMapping("/contact")
    public String contact(){
            System.out.println("npm run build:css");
        return "contact";
    }


    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
