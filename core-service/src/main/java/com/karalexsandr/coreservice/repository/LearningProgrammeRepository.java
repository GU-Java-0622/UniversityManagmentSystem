package com.karalexsandr.coreservice.repository;

import com.karalexsandr.coreservice.entity.LearningProgramme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LearningProgrammeRepository extends JpaRepository<LearningProgramme, Long> {
}