package com.choiye.awspractice.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Emotion {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name= "emotion_id")
    private Long id;
    @Column(nullable = false)
    private String title;
}
