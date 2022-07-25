package com.karalexsandr.coreservice.repository;

import com.karalexsandr.coreservice.entity.Stream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StreamRepository extends PagingAndSortingRepository<Stream, Long> {
}