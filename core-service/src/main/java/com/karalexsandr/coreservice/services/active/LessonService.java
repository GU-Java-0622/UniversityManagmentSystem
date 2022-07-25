package com.karalexsandr.coreservice.services.active;

import com.karalexsandr.coreservice.entity.CourseTemplate;
import com.karalexsandr.coreservice.entity.Lesson;
import com.karalexsandr.coreservice.entity.LessonTemplate;
import com.karalexsandr.coreservice.repository.LessonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class LessonService {
    private final LessonRepository repository;


    public LessonService(LessonRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public List<Lesson> createLessonsByCourseTemplate(CourseTemplate courseTemplate){
        List<Lesson> lessons = new ArrayList<>();
        List<LessonTemplate> lessonTemplates = courseTemplate.getLessonTemplates();
        for(LessonTemplate lessonTemplate:lessonTemplates){
            Lesson lesson = new Lesson();
            lesson.setLessonTemplate(lessonTemplate);
            lesson.setTheme(lessonTemplate.getTheme());
            lesson.setTrainingManualUri(lessonTemplate.getTrainingManualUri());
            lesson.setHomeWorkUri(lessonTemplate.getHomeWorkUri());
            lesson.setFinished(false);
            repository.save(lesson);
            lessons.add(lesson);
        }
        return lessons;
    }
}
