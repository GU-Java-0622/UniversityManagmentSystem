package com.karalexsandr.coreservice.service;

import com.karalexsandr.coreservice.entity.Person;
import com.karalexsandr.coreservice.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository repository;

    public Page<Person> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public Optional<Person> findById(Long id){
        return repository.findById(id);
    }
}
