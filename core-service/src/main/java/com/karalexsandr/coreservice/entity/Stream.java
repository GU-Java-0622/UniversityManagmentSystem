package com.karalexsandr.coreservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "active_stream")
@Getter
@Setter
public class Stream {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "stream_template_id")
    private StreamTemplate streamTemplate;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person teacher;

    @OneToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @OneToMany(mappedBy = "stream")
    private List<LearningProgramme> programmes;

    @Column(name = "started_at")
    private LocalDate startedAt;

    @Column(name = "finished_at")
    private LocalDate finishedAt;

    @Enumerated(value = EnumType.STRING)
    private StatusStream statusStream;
}
