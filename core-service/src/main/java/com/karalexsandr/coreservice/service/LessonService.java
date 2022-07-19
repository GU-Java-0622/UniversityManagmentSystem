package com.karalexsandr.coreservice.service;

import com.karalexsandr.coreservice.model.Lesson;
import com.karalexsandr.coreservice.repository.lesson.LessonRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class LessonService {
    private final LessonRepositoryImpl lessonRepository;


    public Page<Lesson> findAll(Pageable pageable){
        return lessonRepository.findAll(pageable);
    }

    public Lesson findByTheme(String theme){
        return lessonRepository.findByTheme(theme);
    }


}
