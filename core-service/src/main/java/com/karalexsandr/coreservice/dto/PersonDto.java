package com.karalexsandr.coreservice.dto;

import com.karalexsandr.coreservice.entity.Person;
import lombok.Data;

@Data
public class PersonDto {
    private Long id;

    public PersonDto(Person person) {
        this.id = person.getId();
    }
}