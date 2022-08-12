package ru.geekbrains.coreservice.services;

import ru.geekbrains.coreservice.dto.request.FacultyCreateDto;
import ru.geekbrains.coreservice.dto.response.FacultyFullResponseDto;
import ru.geekbrains.coreservice.dto.response.FacultyResponseDto;
import ru.geekbrains.coreservice.entity.Faculty;
import ru.geekbrains.coreservice.repository.FacultyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.commons.exception.ResourceNotFoundException;

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

    public List<Faculty> getAll() {
       return repository.findAll();

    }

    public Faculty getById(Long id) {
        return repository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Не найден факультет с id: "+id));
    }
}
