package com.karalexsandr.coreservice.dto;

import com.karalexsandr.coreservice.entity.StreamTemplate;
import lombok.Data;

@Data
public class StreamTemplateDto {
    private Long id;
    private String title;

    public StreamTemplateDto(StreamTemplate template){
        this.id = template.getId();
        this.title = template.getTitle();
    }
}
