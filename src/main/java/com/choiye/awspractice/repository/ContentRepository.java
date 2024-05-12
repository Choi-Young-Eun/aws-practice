package com.choiye.awspractice.repository;

import com.choiye.awspractice.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long> {
}
