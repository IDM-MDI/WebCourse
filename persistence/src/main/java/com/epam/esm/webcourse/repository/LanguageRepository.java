package com.epam.esm.webcourse.repository;

import com.epam.esm.webcourse.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {
    Language findByName(String name);
}