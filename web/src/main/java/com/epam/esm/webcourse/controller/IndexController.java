package com.epam.esm.webcourse.controller;

import com.epam.esm.webcourse.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping(value = {"/","/authorization"})
    public String authorization(Model model) {
        model.addAttribute("loginUser",new User());
        return "authorization";
    }
    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("registrUser",new User());
        return "registration";
    }
    @GetMapping("/main")
    public String main() {
        return "main";
    }

}
