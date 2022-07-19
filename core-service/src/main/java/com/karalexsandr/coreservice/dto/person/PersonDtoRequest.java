package com.karalexsandr.coreservice.dto.person;

import lombok.Data;

import javax.persistence.Column;

@Data
public class PersonDtoRequest {
    private Long userId;
    private String firstName;
    private String lastName;
    private String surname;
}
