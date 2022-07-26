package com.karalexsandr.coreservice.repository;


import com.karalexsandr.coreservice.entity.Course;
import com.karalexsandr.coreservice.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface LessonRepository extends JpaRepository<Lesson, Long> {

    List<Lesson> getLessonByCourseInAndStartedAtIsNull(List<Course> courses);
}