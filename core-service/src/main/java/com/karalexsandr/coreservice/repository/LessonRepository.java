package com.karalexsandr.coreservice.repository;

import com.karalexsandr.coreservice.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}