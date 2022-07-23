package com.karalexsandr.coreservice.repository;

import com.karalexsandr.coreservice.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}