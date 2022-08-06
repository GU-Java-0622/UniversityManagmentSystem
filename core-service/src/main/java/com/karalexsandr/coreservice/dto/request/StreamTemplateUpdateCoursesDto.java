package com.karalexsandr.coreservice.dto.request;

import lombok.Data;
import java.util.List;

@Data
public class StreamTemplateUpdateCoursesDto {
    private Long streamTemplateId;
    private List<Long> coursesTemplateIds;
}
