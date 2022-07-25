package com.karalexsandr.coreservice.service;

import com.karalexsandr.coreservice.entity.CourseTemplate;
import com.karalexsandr.coreservice.repository.CourseTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseTemplateService {
    private final CourseTemplateRepository repository;

    public Page<CourseTemplate> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public Optional<CourseTemplate> findById(Long id){
        return repository.findById(id);
    }
}
