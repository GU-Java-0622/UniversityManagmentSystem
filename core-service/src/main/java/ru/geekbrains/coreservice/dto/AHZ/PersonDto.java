package ru.geekbrains.coreservice.dto.AHZ;

import ru.geekbrains.coreservice.entity.Person;
import lombok.Data;

@Data
public class PersonDto {
    private Long id;

    public PersonDto(Person person) {
        this.id = person.getId();
    }
}