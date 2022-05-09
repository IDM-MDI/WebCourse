package com.epam.esm.webcourse.repository;

import com.epam.esm.webcourse.entity.OwnCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnCourseRepository extends JpaRepository<OwnCourse, Long> {
}