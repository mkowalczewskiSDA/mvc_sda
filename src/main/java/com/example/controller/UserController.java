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
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;

@Controller
//@SessionScope - inicjalizacja przy każdym logowania się użytkownika do sesji
//@RequestScope - inicjalizacja przy każdym requescie http
//@ApplicationScope - jedna inicjalizacja na całe życie aplikacji
public class UserController {

    String imie;

    @PostConstruct
    public void init(){
        imie = "janusz";
        System.out.println(imie);
        System.out.println("zainicjalizowałem stronę");
    }

    @Autowired
    UserDAO userDAO;

    @RequestMapping("/main")
    public String mainPage(Model model){
        System.out.println(imie);
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
        imie = "stefan";
        System.out.println(imie);
        model.addAttribute("user", new User());
        return "post";
    }

    @PostMapping("/save")
    public String postAction(User user){
        user.setId(5);
        return "index";
    }



}
