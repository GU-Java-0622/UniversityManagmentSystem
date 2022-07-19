package com.karalexsandr.coreservice.dto.faculty;

import com.karalexsandr.coreservice.entity.Faculty;
import com.karalexsandr.coreservice.entity.Group;
import com.karalexsandr.coreservice.entity.LearningProgramme;
import lombok.Data;

import java.util.List;

@Data
public class FacultyDtoResponse {
    private Long id;
    private String title;
    private List<Group> groupList;
    private LearningProgramme learningProgramme;

    public FacultyDtoResponse(Faculty faculty) {
        this.id = faculty.getId();
        this.title = faculty.getTitle();
        this.groupList = faculty.getGroupList();
        this.learningProgramme = faculty.getLearningProgramme();
    }

    public FacultyDtoResponse(Long id, String title, List<Group> groupList,
                              LearningProgramme learningProgramme) {
        this.id = id;
        this.title = title;
        this.groupList = groupList;
        this.learningProgramme = learningProgramme;
    }
}
