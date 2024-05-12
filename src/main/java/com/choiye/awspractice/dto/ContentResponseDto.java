package com.choiye.awspractice.dto;

import com.choiye.awspractice.entity.Content;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;

@Getter
@NoArgsConstructor
public class ContentResponseDto {
    private Long id;
    private String sentence;
    private String created;
    private String emotion;
    private String writer;

    public static ContentResponseDto of(Content content){
        ContentResponseDto contentResponseDto = new ContentResponseDto();
        contentResponseDto.id = content.getId();
        contentResponseDto.sentence = content.getSentence();
        contentResponseDto.created = content.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        contentResponseDto.emotion = content.getEmotion().getTitle();
        contentResponseDto.writer = content.getUser().getNickname();

        return contentResponseDto;
    }
}
