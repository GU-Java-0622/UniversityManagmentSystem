package com.karalexsandr.coreservice.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "lessons")
public class Lesson {
    @Id
    private Long id;
    private String theme;
    private LocalTime duration;


}
