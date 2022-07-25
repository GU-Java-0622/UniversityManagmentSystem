package com.karalexsandr.coreservice.repository;

import com.karalexsandr.coreservice.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LessonRepository extends PagingAndSortingRepository<Lesson, Long> {
}