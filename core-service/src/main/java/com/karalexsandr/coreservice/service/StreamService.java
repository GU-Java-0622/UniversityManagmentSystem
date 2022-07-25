package com.karalexsandr.coreservice.service;

import com.karalexsandr.coreservice.entity.Stream;
import com.karalexsandr.coreservice.repository.StreamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StreamService {
    private final StreamRepository repository;

    public Page<Stream> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public Optional<Stream> findById(Long id){
        return repository.findById(id);
    }
}
