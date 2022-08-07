package com.karalexsandr.coreservice.services.active;

import com.karalexsandr.coreservice.entity.Course;
import com.karalexsandr.coreservice.entity.Person;
import com.karalexsandr.coreservice.entity.StreamTemplate;
import com.karalexsandr.coreservice.exception.CoreException;
import com.karalexsandr.coreservice.repository.CourseRepository;
import com.karalexsandr.coreservice.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository repository;
    private final LessonService lessonService;
    private final PersonService personService;


    @Transactional
    public List<Course> createCoursesForStreamTemplate(StreamTemplate streamTemplate) {
        List<Course> courses = streamTemplate.getCourseTemplates().stream()
                .map(ct -> {
                    Course course = new Course();
                    course.setTitle(ct.getTitle());
                    course.setCourseTemplate(ct);
                    course.setLessons(lessonService.createLessonsByCourseTemplate(ct));
                    return course;
                })
                .collect(Collectors.toList());
        repository.saveAll(courses);
        return courses;
    }

    public void setTeacher(Long idCourse, Long idTeacher) {
        Person person = personService.getTeacherById(idTeacher);
        int i = repository.setTeacher(person, idCourse);
        if (i == 0) {
            throw new CoreException("Не удалось припязать учителя с id: " + idTeacher);
        }
    }
}
