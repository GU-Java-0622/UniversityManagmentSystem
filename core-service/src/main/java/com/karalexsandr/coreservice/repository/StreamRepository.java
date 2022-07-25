package com.karalexsandr.coreservice.repository;

import com.karalexsandr.coreservice.entity.StatusStream;
import com.karalexsandr.coreservice.entity.Stream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface StreamRepository extends JpaRepository<Stream, Long> {
    @Modifying
    @Query("update Stream as s set s.statusStream =?1 where s.id =?2")
    int startedStream(StatusStream status, Long id);
}