package com.karalexsandr.coreservice.dto.faculty;

import com.karalexsandr.coreservice.entity.Group;
import com.karalexsandr.coreservice.entity.LearningProgramme;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Data
public class FacultyDtoRequest {
    private Long id;
    private String title;
    private List<Group> groupList;
    private LearningProgramme learningProgramme;
}
