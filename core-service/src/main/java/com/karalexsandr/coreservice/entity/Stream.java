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

    @OneToMany(mappedBy = "stream")
    private List<Course> course;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Enumerated(value = EnumType.STRING)
    private StatusStream statusStream;

    @ManyToOne
    @JoinColumn(name="facultity_id")
    private Faculty faculty;

    @ManyToMany(mappedBy = "stream")
    private List<Person> students;
}
