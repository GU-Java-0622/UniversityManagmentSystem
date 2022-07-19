package com.karalexsandr.coreservice.service;

import com.karalexsandr.coreservice.model.Group;
import com.karalexsandr.coreservice.repository.group.GroupRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepositoryImpl groupRepository;

    public Page<Group> findAll(Pageable pageable) {
        return groupRepository.findAll(pageable);
    }

    public Group findByTitle(String title){
        return groupRepository.findByTitle(title);
    }
}
