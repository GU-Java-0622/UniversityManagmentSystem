package com.karalexsandr.coreservice.service;

import com.karalexsandr.coreservice.model.*;
import com.karalexsandr.coreservice.repository.faculty.FacultyRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class FacultyService {
    private final FacultyRepositoryImpl facultyRepository;

    public Page<Faculty> findAll(Pageable pageable) {
       return facultyRepository.findAll(pageable);
    }

    public Faculty findByTitle(String title){
        return facultyRepository.findByTitle(title);
    }

}
