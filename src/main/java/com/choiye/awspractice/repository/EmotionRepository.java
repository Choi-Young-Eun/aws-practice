package com.choiye.awspractice.repository;

import com.choiye.awspractice.entity.Emotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmotionRepository extends JpaRepository<Emotion, Long> {
}
