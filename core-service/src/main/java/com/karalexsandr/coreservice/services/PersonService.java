package com.karalexsandr.coreservice.services;

import com.karalexsandr.coreservice.entity.Person;
import com.karalexsandr.coreservice.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.exception.ResourceNotFoundException;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository repository;

    public Person findPersonById(Long id){
        return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Не найден студент с id: "+id));
    }

    public Person getById(Long id){
        return repository.getReferenceById(id);
    }
}
