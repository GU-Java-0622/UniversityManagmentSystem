package com.karalexsandr.coreservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "faculties")
public class Faculty {
    @Id
    private Long id;
    private String title;
    private List<Group> groupList;
    private List<LearningProgramme> learningProgramme;

}
