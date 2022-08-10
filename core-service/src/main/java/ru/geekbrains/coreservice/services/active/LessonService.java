package ru.geekbrains.coreservice.services.active;

import ru.geekbrains.coreservice.entity.Course;
import ru.geekbrains.coreservice.entity.CourseTemplate;
import ru.geekbrains.coreservice.entity.Lesson;
import ru.geekbrains.coreservice.repository.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LessonService {
    private final LessonRepository repository;


    @Transactional
    public List<Lesson> createLessonsByCourseTemplate(CourseTemplate courseTemplate, Course course){
        List<Lesson> lessons = courseTemplate.getLessonTemplates().stream()
                .map(lt ->{
                    Lesson lesson = new Lesson();
                    lesson.setLessonTemplate(lt);
                    lesson.setTheme(lt.getTheme());
                    lesson.setTrainingManualUri(lt.getTrainingManualUri());
                    lesson.setHomeWorkUri(lt.getHomeWorkUri());
                    lesson.setFinished(false);
                    lesson.setCourse(course);
                    return lesson;
                })
                .collect(Collectors.toList());
        repository.saveAll(lessons);
        return lessons;
    }

}
