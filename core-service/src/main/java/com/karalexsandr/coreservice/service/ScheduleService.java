package com.karalexsandr.coreservice.service;

import com.karalexsandr.coreservice.model.Schedule;
import com.karalexsandr.coreservice.repository.schedule.ScheduleRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepositoryImpl scheduleRepository;

    public Page<Schedule> findAll(Pageable pageable) {
        return scheduleRepository.findAll(pageable);
    }

    public Schedule findById(Long id){
        return scheduleRepository.findById(id);
    }
}
