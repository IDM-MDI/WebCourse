package com.epam.esm.webcourse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping(value = {"/","/login"})
    public String authorization() {
        return "authorization";
    }
    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }
    @GetMapping("/main")
    public String main() {
        return "authorization";
    }
}
