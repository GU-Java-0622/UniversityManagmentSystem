package com.karalexsandr.coreservice.service;

import com.karalexsandr.coreservice.entity.Course;
import com.karalexsandr.coreservice.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository repository;

    public Page<Course> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public Optional<Course> findById(Long id){
        return repository.findById(id);
    }
}
