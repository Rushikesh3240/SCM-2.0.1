package com.scm20.scm22.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @RequestMapping("/home")
    public String homeController(){
        return "home";
    }
}
