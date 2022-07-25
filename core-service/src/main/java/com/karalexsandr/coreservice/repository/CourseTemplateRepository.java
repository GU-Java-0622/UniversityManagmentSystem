package com.karalexsandr.coreservice.repository;

import com.karalexsandr.coreservice.entity.CourseTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseTemplateRepository extends JpaRepository<CourseTemplate, Long> {
}