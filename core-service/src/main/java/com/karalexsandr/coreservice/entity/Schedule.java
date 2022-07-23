package com.karalexsandr.coreservice.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "schedules")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "group_id")
    private Group groupId;

    @OneToOne
    @JoinColumn(name = "learning_programme_id")
    private LearningProgramme learningProgramme;

    @OneToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @Column(name = "started_at")
    private LocalDateTime startedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Schedule schedule = (Schedule) o;
        return id != null && Objects.equals(id, schedule.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
