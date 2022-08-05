package com.karalexsandr.coreservice.controllers.AHZ;

import com.karalexsandr.coreservice.dto.response.AHZ.CourseResponseDto;
import com.karalexsandr.coreservice.services.active.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;



@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/courses")
public class CourseController {
    private final CourseService courseService;

    @PatchMapping ("/{id}/teacher/{idTeacher}")
    public void setTeacher(@PathVariable Long id, @PathVariable Long idTeacher){
        courseService.setTeacher(id,idTeacher);
    }

    @GetMapping
    public Page<CourseResponseDto> findAll(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "5") Integer size) {
        if (page < 1) {
            page = 1;
        }
        return courseService.findAll(PageRequest.of(page-1, size));
    }

}
