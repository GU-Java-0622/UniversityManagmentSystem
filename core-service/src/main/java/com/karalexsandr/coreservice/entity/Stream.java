package com.karalexsandr.coreservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    @JsonBackReference
    private List<Course> course;


    @Enumerated(value = EnumType.STRING)
    private StatusStream statusStream;

    @ManyToOne
    @JoinColumn(name="facultity_id")
    private Faculty faculty;

    @ManyToMany(mappedBy = "stream")
    private List<Person> students;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "update_at")
    private LocalDateTime updatedAt;
}
