package com.karalexsandr.coreservice.service;

import com.karalexsandr.coreservice.entity.StreamTemplate;
import com.karalexsandr.coreservice.repository.StreamTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StreamTemplateService {
    private final StreamTemplateRepository repository;

    public Page<StreamTemplate> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public Optional<StreamTemplate> findById(Long id){
        return repository.findById(id);
    }
}
