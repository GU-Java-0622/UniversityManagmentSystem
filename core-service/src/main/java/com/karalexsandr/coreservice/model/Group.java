package com.karalexsandr.coreservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "groups")
public class Group {
    @Id
    private Long id;
    private String title;
    private List<Integer> students;
    private List<Integer> teachers;



}
