package com.karalexsandr.coreservice.service;

import com.karalexsandr.coreservice.model.LearningProgramme;
import com.karalexsandr.coreservice.repository.learningProgramme.LearningProgrammeRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LearningProgrammeService {
    private final LearningProgrammeRepositoryImpl learningProgrammeRepository;

    public Page<LearningProgramme> findAll(Pageable pageable) {
        return learningProgrammeRepository.findAll(pageable);
    }

    public LearningProgramme findByTitle(String title){
        return learningProgrammeRepository.findByTitle(title);
    }
}
