package com.karalexsandr.coreservice.dto.AHZ;

import com.karalexsandr.coreservice.entity.StatusStream;
import com.karalexsandr.coreservice.entity.Stream;
import lombok.Data;

@Data
public class StreamDto{
    private Long id;
    private StatusStream statusStream;
    private Integer countOfStudents;

    public StreamDto (Stream stream){
        this.id = stream.getId();
        this.countOfStudents = stream.getStudents().size();
    }
}
