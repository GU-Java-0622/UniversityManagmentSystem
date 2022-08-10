package ru.geekbrains.coreservice.repository;

import ru.geekbrains.coreservice.entity.LessonTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonTemplateRepository extends JpaRepository<LessonTemplate, Long> {
}