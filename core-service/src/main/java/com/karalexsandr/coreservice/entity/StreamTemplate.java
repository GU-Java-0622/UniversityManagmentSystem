package com.karalexsandr.coreservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "stream_template")
@Entity
@Getter
@Setter
public class StreamTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToMany
    @JoinTable(name = "programme_template_facultiy",
            joinColumns = @JoinColumn(name = "programme_template_id"),
            inverseJoinColumns = @JoinColumn(name = "faculty_id") )
    private List<CourseTemplate> programmeTemplates;

    @ManyToOne
    @JoinColumn(name="facultity_id")
    private Faculty faculties;

}