package com.karalexsandr.coreservice.entity;



import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;



@AllArgsConstructor
@NoArgsConstructor
@Table(name = "faculties")
@Entity
@Getter
@Setter
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "faculty")
    private List<Group> groups;

    @ManyToMany(mappedBy = "faculties")
    private List<CourseTemplate> cours;

    @Column(name = "created_at")
    private LocalDateTime createAt;

}
