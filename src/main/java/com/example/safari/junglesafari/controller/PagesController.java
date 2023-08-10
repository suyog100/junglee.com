package com.example.safari.junglesafari.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class PagesController {
    @GetMapping("/home")
    public String getHomepage(){
        return "home";
    }

    @GetMapping("/home/packageList")
    public String getPackageList(){
        return "packageList.html";
    }


}
