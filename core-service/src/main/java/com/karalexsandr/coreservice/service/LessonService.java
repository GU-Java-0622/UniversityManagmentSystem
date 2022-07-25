package com.karalexsandr.coreservice.service;

import com.karalexsandr.coreservice.entity.Lesson;
import com.karalexsandr.coreservice.repository.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LessonService {
    private final LessonRepository repository;

    public Page<Lesson> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public Optional<Lesson> findById(Long id){
        return repository.findById(id);
    }
}
