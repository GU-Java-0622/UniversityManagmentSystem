package ru.geekbrains.coreservice.repository.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.geekbrains.commons.entity.UserDto;
import ru.geekbrains.commons.exception.ResourceNotFoundException;
import ru.geekbrains.coreservice.dto.response.StreamResponseDto;
import ru.geekbrains.coreservice.entity.Person;
import ru.geekbrains.coreservice.entity.Stream;
import ru.geekbrains.coreservice.integrations.AuthServiceIntegration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class StreamConverter {

    private final AuthServiceIntegration authServiceIntegration;


    public StreamResponseDto entityToDto(Stream streamEntity) {
        StreamResponseDto dto = new StreamResponseDto(streamEntity);
        List<Long> teachersId = new ArrayList<>();
        streamEntity.getCourse().forEach(course -> {
            if (course.getTeacher() != null) {
                teachersId.add(course.getTeacher().getId());
            }
        });
        if (!teachersId.isEmpty()) {
            List<UserDto> teachers = authServiceIntegration.getUserListById(teachersId).getUsers();
            dto.getCourseDto().forEach(x -> x.setTeacher(teachers.stream()
                    .filter(y -> y.getId().equals(x.getTeacherId())).findFirst().orElseThrow(() -> new ResourceNotFoundException("Не найден учитель с id: " + x))));
        }
        List<Long> studentsId = streamEntity.getStudents().stream().map(Person::getId).collect(Collectors.toList());
        if (!studentsId.isEmpty()) {
            dto.setStudents(authServiceIntegration.getUserListById(studentsId).getUsers());
        }
        return dto;
    }
}
