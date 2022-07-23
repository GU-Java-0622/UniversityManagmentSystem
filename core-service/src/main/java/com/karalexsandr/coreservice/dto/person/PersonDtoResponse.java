package com.karalexsandr.coreservice.dto.person;

import com.karalexsandr.coreservice.entity.Person;
import lombok.Data;

@Data
public class PersonDtoResponse {
    private Long userId;
    private String firstName;
    private String lastName;
    private String surname;

    public PersonDtoResponse(Person person) {
        this.userId = person.getUserId();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.surname = person.getSurname();
    }

    public PersonDtoResponse(Long userId, String firstName, String lastName, String surname) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.surname = surname;
    }
}
