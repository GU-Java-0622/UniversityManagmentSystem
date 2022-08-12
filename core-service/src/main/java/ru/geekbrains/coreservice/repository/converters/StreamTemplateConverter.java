package ru.geekbrains.coreservice.repository.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.geekbrains.coreservice.dto.response.StreamTemplateResponseDto;
import ru.geekbrains.coreservice.entity.StreamTemplate;
import ru.geekbrains.coreservice.services.template.CourseTemplateService;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class StreamTemplateConverter {

    private final CourseTemplateService courseTemplateService;

    public StreamTemplateResponseDto entityToDto(StreamTemplate template) {

        StreamTemplateResponseDto templateResponseDto = new StreamTemplateResponseDto(template);
        templateResponseDto.setCourseNotInTemplate(courseTemplateService.getCourseNotInStreamTemplate(templateResponseDto
                        .getCourseTemplate()
                        .stream().map(StreamTemplateResponseDto.CourseTemplateDto::getId)
                        .collect(Collectors.toList())).stream()
                .map(StreamTemplateResponseDto.CourseTemplateDto::new).collect(Collectors.toList()));

        return templateResponseDto;
    }

}
