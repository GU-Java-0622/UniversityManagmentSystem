package com.karalexsandr.coreservice.repository;

import com.karalexsandr.coreservice.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}