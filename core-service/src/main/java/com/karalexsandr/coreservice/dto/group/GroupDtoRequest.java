package com.karalexsandr.coreservice.dto.group;

import com.karalexsandr.coreservice.entity.Person;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Set;

@Data
public class GroupDtoRequest {
    private Long id;
    private String title;
    private Set<Person> personSet;
    private Person teacher;
}
