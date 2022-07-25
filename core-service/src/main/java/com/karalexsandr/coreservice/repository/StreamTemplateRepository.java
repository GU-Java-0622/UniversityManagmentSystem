package com.karalexsandr.coreservice.repository;

import com.karalexsandr.coreservice.entity.StreamTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StreamTemplateRepository extends PagingAndSortingRepository<StreamTemplate, Long> {
}