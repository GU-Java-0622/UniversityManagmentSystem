package com.karalexsandr.coreservice.services;

import com.karalexsandr.coreservice.entity.Person;
import com.karalexsandr.coreservice.exception.CoreException;
import com.karalexsandr.coreservice.integrations.AuthServiceIntegration;
import com.karalexsandr.coreservice.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.entity.ERole;
import web.entity.ProfileDto;
import web.exception.ResourceNotFoundException;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository repository;
    private final AuthServiceIntegration authServiceIntegration;

    public Person findPersonById(Long id){
        return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Не найден студент с id: "+id));
    }

    public Person getById(Long id){
        return repository.getReferenceById(id);
    }

    public Person getStudentById(Long id){
        Person person = new Person();
        ProfileDto profileDto = authServiceIntegration.getProfileById(id);
        if (profileDto!=null){
            if (profileDto.getRoles().contains(ERole.ROLE_STUDENT)){
                person = repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Не найден студент с id: "+id));;
            }
            else {
                throw new CoreException("Пользователь с ID: " + id + " не студент");
            }
        }
        return person;
    }
    public Person getTeacherById(Long id){
        Person person = new Person();
        ProfileDto profileDto = authServiceIntegration.getProfileById(id);
        if (profileDto!=null){
            if (profileDto.getRoles().contains(ERole.ROLE_TEACHER)){
                person = repository.getReferenceById(id);
            }
            else {
                throw new CoreException("Пользователь с ID: " + id + " не учитель");
            }
        }
        return person;
    }
    public Person getAdminById(Long id){
        Person person = new Person();
        ProfileDto profileDto = authServiceIntegration.getProfileById(id);
        if (profileDto!=null){
            if (profileDto.getRoles().contains(ERole.ROLE_ADMIN)){
                person = repository.getReferenceById(id);
            }
            else {
                throw new CoreException("Пользователь с ID: " + id + " не админ");
            }
        }
        return person;
    }
}
