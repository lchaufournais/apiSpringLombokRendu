package com.exo1.repositories;

import com.exo1.entities.ProjectTaskCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectTaskCountRepository extends JpaRepository<ProjectTaskCount, Long> {
}
