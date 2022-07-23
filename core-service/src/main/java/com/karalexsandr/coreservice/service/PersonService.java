package com.karalexsandr.coreservice.service;

import com.karalexsandr.coreservice.dto.person.PersonDtoResponse;
import com.karalexsandr.coreservice.exceptions.ResourceNotFoundException;
import com.karalexsandr.coreservice.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public PersonDtoResponse findById(Long id){
        return personRepository.findByUserId(id)
                .orElseThrow(()-> new ResourceNotFoundException("Невозможно найти пользователя, не надйен в базе, id: " + id));
    }
}
