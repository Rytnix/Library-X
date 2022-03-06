package com.application.Bookshelf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping({"", "/", "/home"})
    public String getHomePage(){
        return"/fragments/home";
    }
}
