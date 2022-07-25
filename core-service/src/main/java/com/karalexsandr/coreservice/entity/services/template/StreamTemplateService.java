package com.karalexsandr.coreservice.entity.services.template;

import com.karalexsandr.coreservice.entity.StreamTemplate;
import com.karalexsandr.coreservice.entity.services.FacultyService;
import com.karalexsandr.coreservice.repository.StreamTemplateRepository;
import org.springframework.stereotype.Service;
import web.exception.ResourceNotFoundException;

@Service
public class StreamTemplateService {
    private final FacultyService facultyService;
    private final StreamTemplateRepository repository;

    public StreamTemplateService(FacultyService facultyService, StreamTemplateRepository repository) {
        this.facultyService = facultyService;
        this.repository = repository;
    }

    public void createStreamTemplate(String title, Long facultyId){
        StreamTemplate streamTemplate = new StreamTemplate();
        streamTemplate.setTitle(title);
        streamTemplate.setFaculties(facultyService.getFacultyRefById(facultyId));
        repository.save(streamTemplate);
    }

    public StreamTemplate getStreamTemplateRefById(Long id){
       return repository.getReferenceById(id);
    }

    public StreamTemplate findById(Long id){
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Не найден шаблон для потока с id:"+id));
    }
}