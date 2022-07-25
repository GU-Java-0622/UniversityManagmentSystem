package com.karalexsandr.coreservice.repository;

import com.karalexsandr.coreservice.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {
}