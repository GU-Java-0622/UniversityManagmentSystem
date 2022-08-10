package ru.geekbrains.coreservice.repository;


import ru.geekbrains.coreservice.entity.Course;
import ru.geekbrains.coreservice.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface LessonRepository extends JpaRepository<Lesson, Long> {

    List<Lesson> getLessonByCourseInAndStartedAtIsNull(List<Course> courses);
}