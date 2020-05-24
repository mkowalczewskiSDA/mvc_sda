package com.example.controller;

import com.example.dao.UserDAO;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    UserDAO userDAO;

    @RequestMapping("/main")
    public String mainPage(Model model){
        model.addAttribute("users", userDAO.getUsers());
        return "index";
    }

    @RequestMapping("/main/{id}")
    public String mainPageId(@PathVariable("id") int id, Model model){
        model.addAttribute("user", userDAO.getUserById(id));
        return "index";
    }

    @RequestMapping("/post")
    public String postPage(Model model){
        model.addAttribute("user", new User());
        return "post";
    }

    @PostMapping("/save")
    public String postAction(User user){
        user.setId(5);
        return "index";
    }



}
