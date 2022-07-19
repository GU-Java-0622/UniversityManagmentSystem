package com.karalexsandr.coreservice.repository.faculty;

import com.karalexsandr.coreservice.model.Faculty;
import com.karalexsandr.coreservice.model.Lesson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface FacultyRepository  {
    Page<Faculty> findAll(Pageable pageable);

    Faculty findByTitle(String title);
}