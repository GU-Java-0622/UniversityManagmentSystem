package com.karalexsandr.coreservice.services;

import com.karalexsandr.coreservice.dto.request.FacultyCreateDto;
import com.karalexsandr.coreservice.dto.response.FacultyFullResponseDto;
import com.karalexsandr.coreservice.dto.response.FacultyResponseDto;
import com.karalexsandr.coreservice.entity.Faculty;
import com.karalexsandr.coreservice.repository.FacultyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.exception.ResourceNotFoundException;


import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class FacultyService {
    private final FacultyRepository repository;


    public void createFaculty(FacultyCreateDto facultyCreateDto){
        Faculty faculty =new Faculty();
        faculty.setTitle(facultyCreateDto.getTitle());
        repository.save(faculty);
    }


    public Faculty getFacultyRefById(Long id){
        return repository.getReferenceById(id);
    }

    public List<FacultyResponseDto> getAll() {
       return repository.findAll().stream().map(FacultyResponseDto::new).collect(Collectors.toList());

    }

    public FacultyFullResponseDto getById(Long id) {
        return new FacultyFullResponseDto(repository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Не найден факультет с id: "+id)));
    }
}
