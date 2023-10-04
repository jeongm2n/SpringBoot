package com.example.chap02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
    @GetMapping("/hi")
    public String Hello(Model model){
        model.addAttribute("username","서정민");
        return "greetings";
    }

    @GetMapping("/bye")
    public String Bye(Model model){
        model.addAttribute("username","서정민");
        return "goodbye";
    }
}
