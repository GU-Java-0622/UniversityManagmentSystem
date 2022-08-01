package com.karalexsandr.coreservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    private List<CourseTemplate> courseTemplates;

    @ManyToOne
    @JoinColumn(name="facultity_id")
    private Faculty faculties;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "update_at")
    private LocalDateTime updatedAt;

}
