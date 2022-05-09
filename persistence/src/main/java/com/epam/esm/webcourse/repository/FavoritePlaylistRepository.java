package com.epam.esm.webcourse.repository;

import com.epam.esm.webcourse.entity.FavoritePlaylist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoritePlaylistRepository extends JpaRepository<FavoritePlaylist, Long> {
}