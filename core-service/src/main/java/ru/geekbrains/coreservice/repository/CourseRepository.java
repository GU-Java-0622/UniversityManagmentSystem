package ru.geekbrains.coreservice.repository;

import ru.geekbrains.coreservice.entity.Course;
import ru.geekbrains.coreservice.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepository extends JpaRepository<Course, Long> {
    @Modifying
    @Query("update Course as s set s.teacher.id =?1 where s.id =?2")
    int setTeacher(Long person, Long courseId);


}