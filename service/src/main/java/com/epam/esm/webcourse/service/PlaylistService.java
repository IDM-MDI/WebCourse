package com.epam.esm.webcourse.service;

import com.epam.esm.webcourse.entity.Category;
import com.epam.esm.webcourse.entity.Playlist;
import com.epam.esm.webcourse.repository.CategoryRepository;
import com.epam.esm.webcourse.repository.LanguageRepository;
import com.epam.esm.webcourse.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {
    private final PlaylistRepository repository;
    private final CategoryRepository categoryRepository;
    private final LanguageRepository languageRepository;

    @Autowired
    public PlaylistService(PlaylistRepository repository, CategoryRepository categoryRepository, LanguageRepository languageRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
        this.languageRepository = languageRepository;
    }

    public List<Playlist> findAll() {
        List<Playlist> playlists = repository.findAll();
        playlists.forEach(i -> i.setPhotoString(Base64.getEncoder().encodeToString(i.getPhoto())));
        return playlists;
    }

    public Playlist findById(long id) {
        Optional<Playlist> optionalPlaylist = repository.findById(id);
        Playlist playlist = null;
        if(optionalPlaylist.isPresent()) {
            playlist = optionalPlaylist.get();
            playlist.setPhotoString(Base64.getEncoder().encodeToString(playlist.getPhoto()));
        }
        return playlist;
    }

    public void save(Playlist playlist) throws IOException {
        Category oldCategory = playlist.getCategory();
        Category categoryFromDB = categoryRepository.findByName(oldCategory.getName());
        if(categoryFromDB == null){
            categoryRepository.save(oldCategory);
            playlist.setCategory(categoryRepository.findByName(oldCategory.getName()));
        }
        else {
            playlist.setCategory(categoryFromDB);
        }
        playlist.setLanguage(languageRepository.findByName("Русский"));
        playlist.setPhoto(playlist.getFile().getBytes());

        repository.save(playlist);
    }
}
