package com.karalexsandr.coreservice.repository.lesson;

import com.karalexsandr.coreservice.model.Lesson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;



public interface LessonRepository {
    Lesson findByTheme(String theme);

    Page<Lesson> findAll(Pageable pageable);

}