package com.karalexsandr.coreservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class GroupDTO {
    private Long id;
    private String title;
    private Set<Integer> students;
    private Set<Integer> teachers;
}
