package com.karalexsandr.coreservice.repository;

import com.karalexsandr.coreservice.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}