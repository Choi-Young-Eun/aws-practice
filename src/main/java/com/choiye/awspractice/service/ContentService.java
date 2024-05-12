package com.choiye.awspractice.service;

import com.choiye.awspractice.dto.ContentAddDto;
import com.choiye.awspractice.entity.Content;
import com.choiye.awspractice.entity.Emotion;
import com.choiye.awspractice.entity.User;
import com.choiye.awspractice.repository.ContentRepository;
import com.choiye.awspractice.repository.EmotionRepository;
import com.choiye.awspractice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContentService {
    private final ContentRepository contentRepository;
    private final UserRepository userRepository;
    private final EmotionRepository emotionRepository;

    public Long createContent(ContentAddDto contentDto) {
        User user = userRepository.findByEmail(contentDto.getEmail());
        Emotion emotion = emotionRepository.findById(contentDto.getEmotionId()).get();

        Content newContent = Content.builder()
                .sentence(contentDto.getSentence())
                .emotion(emotion)
                .user(user).build();

        return contentRepository.save(newContent).getId();
    }

    public Content getContent(Long contentId) {
        return contentRepository.findById(contentId).get();
    }
}
