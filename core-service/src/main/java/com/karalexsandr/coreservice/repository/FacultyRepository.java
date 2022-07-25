package com.karalexsandr.coreservice.repository;

import com.karalexsandr.coreservice.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FacultyRepository extends PagingAndSortingRepository<Faculty, Long> {
}