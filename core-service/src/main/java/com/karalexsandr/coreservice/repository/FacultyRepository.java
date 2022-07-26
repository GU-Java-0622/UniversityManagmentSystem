package com.karalexsandr.coreservice.repository;

import com.karalexsandr.coreservice.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty,Long> {
}