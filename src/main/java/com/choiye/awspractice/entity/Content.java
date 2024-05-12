package com.choiye.awspractice.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Content extends BaseTime{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name= "content_id")
    private Long id;
    @Column(nullable = false)
    private String sentence;
    @ManyToOne
    @JoinColumn(name="emotion_id")
    private Emotion emotion;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Builder
    Content(String sentence, Emotion emotion, User user){
        this.sentence = sentence;
        this.emotion = emotion;
        this.user = user;
    }
}
