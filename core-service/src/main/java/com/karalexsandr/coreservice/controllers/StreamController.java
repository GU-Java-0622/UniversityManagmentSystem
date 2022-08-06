package com.karalexsandr.coreservice.controllers;

import com.karalexsandr.coreservice.dto.request.AHZ.AddStudentToStreamDto;
import com.karalexsandr.coreservice.dto.request.StreamCreateRequestDto;
import com.karalexsandr.coreservice.services.active.StreamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/streams")
public class StreamController {
    private final StreamService streamService;


    @PostMapping
    public void createStream(@RequestBody StreamCreateRequestDto dto){
        streamService.createStream(dto);
    }

    @PutMapping("/started/{id}")
    public void startedStream(@PathVariable Long id){
        streamService.startedStream(id);
    }

    @PostMapping("/student/add")
    public void addStudent(@RequestBody AddStudentToStreamDto dto){
        streamService.addStudent(dto);
    }

}
