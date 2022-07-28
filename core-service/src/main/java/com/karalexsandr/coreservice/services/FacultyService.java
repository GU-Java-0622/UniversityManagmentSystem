package com.karalexsandr.coreservice.services;

import com.karalexsandr.coreservice.dto.request.FacultyDto;
import com.karalexsandr.coreservice.entity.Faculty;
import com.karalexsandr.coreservice.repository.FacultyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FacultyService {
    private final FacultyRepository repository;


    public void createFaculty(FacultyDto facultyDto){
        Faculty faculty =new Faculty();
        faculty.setTitle(facultyDto.getTitle());
        repository.save(faculty);
    }


    public Faculty getFacultyRefById(Long id){
        return repository.getReferenceById(id);
    }
}
