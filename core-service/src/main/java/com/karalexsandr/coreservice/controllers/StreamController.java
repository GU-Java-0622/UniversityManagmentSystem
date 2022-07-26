package com.karalexsandr.coreservice.controllers;

import com.karalexsandr.coreservice.dto.request.AddStudentToStreamDto;
import com.karalexsandr.coreservice.dto.request.StreamCreateRequestDto;
import com.karalexsandr.coreservice.services.active.StreamService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("api/v1/stream")
public class StreamController {
    private final StreamService streamService;


    public StreamController(StreamService streamService) {
        this.streamService = streamService;
    }

    @PostMapping("/create_stream")
    public void createStream(@RequestBody StreamCreateRequestDto dto){
        streamService.createStream(dto);
    }

    @PutMapping("/started/{id}")
    public void startedStream(@PathVariable Long id){
        streamService.startedStream(id);
    }

    @PostMapping("/add_student")
    public void addStudent(@RequestBody AddStudentToStreamDto dto){
        streamService.addStudent(dto);
    }
}
