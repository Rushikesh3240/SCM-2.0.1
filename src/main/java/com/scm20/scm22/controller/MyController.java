package com.scm20.scm22.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm20.scm22.entities.User;
import com.scm20.scm22.forms.UserForms;
import com.scm20.scm22.helper.Message;
import com.scm20.scm22.helper.MessageType;
import com.scm20.scm22.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MyController {

    @Autowired
    private UserService userService;

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


    @GetMapping("/register")
    public String register(Model model){
        UserForms userForm=new UserForms();
        
        //we can send data from backend
        // userForm.setName("Rushikesh");
        // userForm.setAbout("Hello im Rushikesh i am Billionare Youtuber ");

        model.addAttribute("userForm", userForm);
        return "register";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    // processing register

    @RequestMapping(value = "/do-register",method = RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute("userForm") UserForms userForms,BindingResult bResult, HttpSession session){
        System.out.println("Processing register");
    
        //fetch form data
        //userform

        //validate form data
        if (bResult.hasErrors()) {
            return "register";
        }

        //user Service
        // User user=User.builder()
        //     .name(userForms.getName())
        //     .email(userForms.getEmail())
        //     .about(userForms.getAbout())
        //     .password(userForms.getPassword())
        //     .phoneNumber(userForms.getPhoneNumber())
        //     .profilePic("file:///C:/Users/rushi/Desktop/defaultProfile.jpg")
        //     .build();

        User user=new User();
        user.setName(userForms.getName());
        user.setEmail(userForms.getEmail());
        user.setAbout(userForms.getAbout());
        user.setPassword(userForms.getPassword());
        user.setPhoneNumber(userForms.getPhoneNumber());
        user.setProfilePic("file:///C:/Users/rushi/Desktop/defaultProfile.jpg");

            User savedUser=userService.saveUser(user);
            System.out.println(savedUser);
            Message message=Message.builder().content("Registratoin Successful").type(MessageType.blue).build();
            session.setAttribute("message", message);
        System.out.println(userForms);
        return "redirect:/register";
    }
}
