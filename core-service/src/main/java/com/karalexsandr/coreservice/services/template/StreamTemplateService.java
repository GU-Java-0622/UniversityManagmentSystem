package com.karalexsandr.coreservice.services.template;

import com.karalexsandr.coreservice.dto.StreamTemplateDto;
import com.karalexsandr.coreservice.dto.request.StreamTemplateCreateDto;
import com.karalexsandr.coreservice.entity.StreamTemplate;
import com.karalexsandr.coreservice.repository.StreamTemplateRepository;
import com.karalexsandr.coreservice.services.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import web.exception.ResourceNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StreamTemplateService {
    private final FacultyService facultyService;
    private final StreamTemplateRepository repository;


    public void createStreamTemplate(StreamTemplateCreateDto streamTemplateCreateDto){
        StreamTemplate streamTemplate = new StreamTemplate();
        streamTemplate.setTitle(streamTemplateCreateDto.getTitle());
        streamTemplate.setFaculties(facultyService.getFacultyRefById(streamTemplateCreateDto.getFacultyId()));
        repository.save(streamTemplate);
    }

    public StreamTemplate getStreamTemplateRefById(Long id){
       return repository.getReferenceById(id);
    }

    public StreamTemplate findById(Long id){
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Не найден шаблон для потока с id:"+id));
    }

    public Page<StreamTemplateDto> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(StreamTemplateDto::new);
    }
}
