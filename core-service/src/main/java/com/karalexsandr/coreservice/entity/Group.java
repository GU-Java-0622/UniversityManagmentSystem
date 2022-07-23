package com.karalexsandr.coreservice.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "groups")
@Getter
@Setter
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name="facultity_id")
    private Faculty faculty;

    @OneToMany(mappedBy = "group")
    private List<Person> students;

    @Column(name = "created_at")
    private LocalDateTime createAt;

}
