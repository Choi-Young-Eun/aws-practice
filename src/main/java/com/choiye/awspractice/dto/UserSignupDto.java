package com.choiye.awspractice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UserSignupDto {
    @Email
    private String email;
    @Size(min=8, max=12, message="비밀번호는 최소 8자리, 최대 12자리로 작성해야 합니다.")
    private String password;
    @Size(min=2, max=12, message="닉네임은 최소 2자리, 최대 10자리로 작성해야 합니다.")
    private String nickname;
}
