package com.karalexsandr.coreservice.services.template;

import com.karalexsandr.coreservice.entity.StreamTemplate;
import com.karalexsandr.coreservice.repository.StreamTemplateRepository;
import com.karalexsandr.coreservice.services.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.exception.ResourceNotFoundException;

@Service
@RequiredArgsConstructor
public class StreamTemplateService {
    private final FacultyService facultyService;
    private final StreamTemplateRepository repository;


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
