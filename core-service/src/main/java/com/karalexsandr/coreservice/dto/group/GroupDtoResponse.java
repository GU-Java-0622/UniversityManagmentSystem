package com.karalexsandr.coreservice.dto.group;

import com.karalexsandr.coreservice.entity.Group;
import com.karalexsandr.coreservice.entity.Person;
import lombok.Data;
import java.util.Set;

@Data
public class GroupDtoResponse {
    private Long id;
    private String title;
    private Set<Person> personSet;
    private Person teacher;

    public GroupDtoResponse(Group group) {
        this.id = group.getId();
        this.title = group.getTitle();
        this.personSet = group.getPersonSet();
        this.teacher = group.getTeacher();
    }

    public GroupDtoResponse(Long id, String title, Set<Person> personSet, Person teacher) {
        this.id = id;
        this.title = title;
        this.personSet = personSet;
        this.teacher = teacher;
    }
}
