package com.cloud.autoreadme.repository;

import com.cloud.autoreadme.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
