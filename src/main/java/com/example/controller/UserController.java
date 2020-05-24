package com.example.controller;

import com.example.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    UserDAO userDAO;

    @RequestMapping("/main")
    public String mainPage(Model model){
        model.addAttribute("users", userDAO.getUsers());
        return "index";
    }

}
