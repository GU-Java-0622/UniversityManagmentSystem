package com.karalexsandr.coreservice.repository;

import com.karalexsandr.coreservice.entity.CourseTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CourseTemplateRepository extends PagingAndSortingRepository<CourseTemplate, Long> {
}