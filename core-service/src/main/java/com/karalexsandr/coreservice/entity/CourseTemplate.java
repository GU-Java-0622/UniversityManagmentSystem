package com.karalexsandr.coreservice.entity;

import lombok.*;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cource_template")
@Entity
@Getter
@Setter
public class CourseTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "courseTemplate")
    private List<LessonTemplate> lessonTemplates;

    @Column(name = "created_at")
    private LocalDateTime createAt;

    @ManyToMany(mappedBy = "programmeTemplates")
    private List<StreamTemplate> streamTemplates;

}
