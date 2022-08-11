package ru.geekbrains.coreservice.services;

import ru.geekbrains.coreservice.entity.Person;
import ru.geekbrains.coreservice.exception.CoreException;
import ru.geekbrains.coreservice.integrations.AuthServiceIntegration;
import ru.geekbrains.coreservice.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.commons.entity.ERole;
import ru.geekbrains.commons.entity.ProfileDto;
import ru.geekbrains.commons.exception.ResourceNotFoundException;

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

//    ToDo: Замечания на видео с 1 час : 53 минуты (урок 8). 3 метода соединить в один
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