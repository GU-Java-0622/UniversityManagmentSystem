package com.karalexsandr.coreservice.services.active;

import com.karalexsandr.coreservice.entity.Course;
import com.karalexsandr.coreservice.entity.CourseTemplate;
import com.karalexsandr.coreservice.entity.Lesson;
import com.karalexsandr.coreservice.entity.LessonTemplate;
import com.karalexsandr.coreservice.repository.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LessonService {
    private final LessonRepository repository;


    @Transactional
    public List<Lesson> createLessonsByCourseTemplate(CourseTemplate courseTemplate){
        List<Lesson> lessons = courseTemplate.getLessonTemplates().stream()
                .map(lt ->{
                    Lesson lesson = new Lesson();
                    lesson.setLessonTemplate(lt);
                    lesson.setTheme(lt.getTheme());
                    lesson.setTrainingManualUri(lt.getTrainingManualUri());
                    lesson.setHomeWorkUri(lt.getHomeWorkUri());
                    lesson.setFinished(false);
                    return lesson;
                })
                .collect(Collectors.toList());
        repository.saveAll(lessons);
        return lessons;
    }

    public List<Lesson> getNotReadyLesson(List<Course> courses){
        return repository.getLessonByCourseInAndStartedAtIsNull(courses);
    }
}
