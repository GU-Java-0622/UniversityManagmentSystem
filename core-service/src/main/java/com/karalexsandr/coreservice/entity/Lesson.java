package com.karalexsandr.coreservice.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "theme")
    private String theme;

    @Column(name = "duration")
    private LocalTime duration;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Lesson lesson = (Lesson) o;
        return id != null && Objects.equals(id, lesson.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
