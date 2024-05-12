package com.choiye.awspractice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class ContentAddDto {
    @Email
    private String email;
    @Size(min=10, max=100, message="문장은 최소 10자리, 최대 100자리까지 작성할 수 있습니다.")
    private String sentence;
    @Min(1)
    private Long emotionId;
}
