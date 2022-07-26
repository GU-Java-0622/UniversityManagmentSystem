package com.karalexsandr.coreservice.repository;

import com.karalexsandr.coreservice.entity.LessonTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonTemplateRepository extends JpaRepository<LessonTemplate, Long> {
}