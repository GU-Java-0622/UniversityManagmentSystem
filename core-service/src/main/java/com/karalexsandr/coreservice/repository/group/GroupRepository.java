package com.karalexsandr.coreservice.repository.group;

import com.karalexsandr.coreservice.model.Group;

import com.karalexsandr.coreservice.model.Lesson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface GroupRepository  {
    Group findByTitle(String title);

    Page<Group> findAll(Pageable pageable);
}