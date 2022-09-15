package com.application.Bookshelf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"","/","/home"})
    public String getHomepage(){
        return "index";
    }

    @GetMapping("/support")
    public String support(){
        return "contact-us";
    }
}
