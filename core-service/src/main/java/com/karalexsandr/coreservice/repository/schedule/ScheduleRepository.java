package com.karalexsandr.coreservice.repository.schedule;

import com.karalexsandr.coreservice.model.Group;
import com.karalexsandr.coreservice.model.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ScheduleRepository {
    Schedule findById(Long id);

    Page<Schedule> findAll(Pageable pageable);

}