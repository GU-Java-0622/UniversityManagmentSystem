package com.karalexsandr.coreservice.controllers.AHZ;

import com.karalexsandr.coreservice.dto.request.AHZ.AddStudentToStreamDto;
import com.karalexsandr.coreservice.dto.request.AHZ.StreamCreateRequestDto;
import com.karalexsandr.coreservice.dto.response.AHZ.StreamResponseDto;
import com.karalexsandr.coreservice.services.active.StreamService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    @GetMapping
    public Page<StreamResponseDto> findAll(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "5") Integer size) {
        if (page < 1) {
            page = 1;
        }
        return streamService.findAll(PageRequest.of(page-1, size));
    }
}
