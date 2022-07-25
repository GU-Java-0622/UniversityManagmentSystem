package com.karalexsandr.coreservice.repository;

import com.karalexsandr.coreservice.entity.LessonTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LessonTemplateRepository extends PagingAndSortingRepository<LessonTemplate, Long> {
}