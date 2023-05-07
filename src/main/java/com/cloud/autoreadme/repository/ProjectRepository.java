package com.cloud.autoreadme.repository;

import com.cloud.autoreadme.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
