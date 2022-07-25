package com.karalexsandr.coreservice.services;

import com.karalexsandr.coreservice.entity.Person;
import com.karalexsandr.coreservice.repository.PersonRepository;
import org.springframework.stereotype.Service;
import web.exception.ResourceNotFoundException;

@Service
public class PersonService {
    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Person findPersonById(Long id){
        return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Не найден студент с id: "+id));
    }
}
