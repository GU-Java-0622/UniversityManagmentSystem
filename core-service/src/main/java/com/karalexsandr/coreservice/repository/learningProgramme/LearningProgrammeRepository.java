package com.karalexsandr.coreservice.repository.learningProgramme;

import com.karalexsandr.coreservice.model.Group;
import com.karalexsandr.coreservice.model.LearningProgramme;
import liquibase.pro.packaged.Q;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LearningProgrammeRepository{
    LearningProgramme findByTitle(String title);

    Page<LearningProgramme> findAll(Pageable pageable);

}