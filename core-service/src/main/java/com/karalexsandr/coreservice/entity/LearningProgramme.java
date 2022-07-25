package com.karalexsandr.coreservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "learning_programmes")
@Getter
@Setter
public class LearningProgramme { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "learning_programme_template_id")
    private LearningProgrammeTemplate learningProgrammeTemplate;

    @ManyToOne
    @JoinColumn(name = "stream_id")
    private Stream stream;


}
