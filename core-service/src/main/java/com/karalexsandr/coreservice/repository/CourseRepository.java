package com.karalexsandr.coreservice.repository;

import com.karalexsandr.coreservice.entity.Course;
import com.karalexsandr.coreservice.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepository extends JpaRepository<Course, Long> {
    @Modifying
    @Query("update Course as s set s.teacher =?1 where s.id =?2")
    int setTeacher(Person person, Long id);
}