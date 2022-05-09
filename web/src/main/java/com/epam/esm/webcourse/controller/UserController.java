package com.epam.esm.webcourse.controller;

import com.epam.esm.webcourse.entity.Category;
import com.epam.esm.webcourse.entity.Language;
import com.epam.esm.webcourse.entity.Playlist;
import com.epam.esm.webcourse.entity.User;
import com.epam.esm.webcourse.service.UserService;
import com.epam.esm.webcourse.validation.SecurityValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public String registration(@ModelAttribute("registrUser") User user) {
        service.registration(user);
        return "redirect:/authorization";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("loginUser") User user, HttpSession session) {
        boolean result = service.login(user);
        if(result) {
            session.setAttribute("user",user);
            return "redirect:/main";
        }
        else {
            return "redirect:/authorization";
        }
    }

    @GetMapping
    public String main() {
        return "redirect:/main";
    }

    @GetMapping("/add")
    public String addCourse(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if(SecurityValidator.isValidUser(user)) {
            Playlist playlist = new Playlist();
            playlist.setCategory(new Category());
            playlist.setLanguage(new Language());
            model.addAttribute("addPlaylist",playlist);
            return "addcourse";
        }
        else {
            return "redirect:/authorization";
        }
    }

    @GetMapping("/favorite")
    public String favorite(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if(SecurityValidator.isValidUser(user)) {
            return "favorite";
        }
        else {
            return "redirect:/authorization";
        }
    }

    @GetMapping("/cart")
    public String cart(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if(SecurityValidator.isValidUser(user)) {
            return "cart";
        }
        else {
            return "redirect:/authorization";
        }
    }
}
