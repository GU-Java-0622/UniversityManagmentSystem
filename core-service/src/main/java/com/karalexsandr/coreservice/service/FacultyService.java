package com.karalexsandr.coreservice.service;

import com.karalexsandr.coreservice.entity.Faculty;
import com.karalexsandr.coreservice.repository.FacultyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FacultyService {
    private final FacultyRepository repository;

    public Page<Faculty> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public Optional<Faculty> findById(Long id){
        return repository.findById(id);
    }
}
