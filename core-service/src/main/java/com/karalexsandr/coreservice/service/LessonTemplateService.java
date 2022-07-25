package com.karalexsandr.coreservice.service;

import com.karalexsandr.coreservice.entity.LessonTemplate;
import com.karalexsandr.coreservice.repository.LessonTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LessonTemplateService {
    private final LessonTemplateRepository repository;

    public Page<LessonTemplate> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public Optional<LessonTemplate> findById(Long id){
        return repository.findById(id);
    }
}
