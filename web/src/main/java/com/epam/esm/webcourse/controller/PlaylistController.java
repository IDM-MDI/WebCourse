package com.epam.esm.webcourse.controller;


import com.epam.esm.webcourse.entity.Playlist;
import com.epam.esm.webcourse.entity.User;
import com.epam.esm.webcourse.repository.PlaylistRepository;
import com.epam.esm.webcourse.service.PlaylistService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Base64;
import java.util.List;

@Controller
@RequestMapping("/courses")
public class PlaylistController {

    private final PlaylistService service;

    @Autowired
    public PlaylistController(PlaylistRepository repository, PlaylistService service) {
        this.service = service;
    }

    @GetMapping
    public String courses(Model model) {
        List<Playlist> playlistList = service.findAll();
        model.addAttribute("playlists",playlistList);
        return "courselist";
    }

    @GetMapping("/{id}")
    public String courseById(@PathVariable long id, Model model) {
        Playlist playlist = service.findById(id);
        if(playlist != null) {
            model.addAttribute("courseById",playlist);
            model.addAttribute("photoById", Base64.getEncoder().
                    encodeToString(playlist.getPhoto()));
            return "course";
        }
        else {
            return "redirect:/main";
        }
    }

    @SneakyThrows
    @PostMapping
    public String addCourse(@ModelAttribute("addPlaylist")Playlist playlist, HttpSession session) {
        User user = (User) session.getAttribute("user");
        playlist.setUserEmail(user.getEmail());
        service.save(playlist);
        return "redirect:/courses";
    }
}
