package com.karalexsandr.coreservice.repository;

import com.karalexsandr.coreservice.entity.CourseTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseTemplateRepository extends JpaRepository<CourseTemplate, Long> {
    List<CourseTemplate> findAllByIdNotIn(List<Long> idList);
    List<CourseTemplate> findAllByIdIn(List<Long> idList);
}