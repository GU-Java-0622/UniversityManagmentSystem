package com.karalexsandr.coreservice.services;

import com.karalexsandr.coreservice.dto.request.FacultyDto;
import com.karalexsandr.coreservice.dto.response.FacultyResponseDto;
import com.karalexsandr.coreservice.entity.Faculty;
import com.karalexsandr.coreservice.repository.FacultyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class FacultyService {
    private final FacultyRepository repository;

public List<Faculty> findAll(){
    return repository.findAll();
}

    public void createFaculty(FacultyDto facultyDto){
        Faculty faculty =new Faculty();
        faculty.setTitle(facultyDto.getTitle());
        repository.save(faculty);
    }


    public Faculty getFacultyRefById(Long id){
        return repository.getReferenceById(id);
    }

    public List<FacultyResponseDto> getAll() {
       return repository.findAll().stream().map(FacultyResponseDto::new).collect(Collectors.toList());

    }
}
