package com.choiye.awspractice.service;

import com.choiye.awspractice.dto.UserSignupDto;
import com.choiye.awspractice.entity.User;
import com.choiye.awspractice.repository.RedisRespository;
import com.choiye.awspractice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RedisRespository redisRespository;

    public Long createUser(UserSignupDto signupDto){
        User newUser = User.builder()
                .email(signupDto.getEmail())
                .password(signupDto.getPassword())
                .nickname(signupDto.getNickname()).build();
        return userRepository.save(newUser).getId();
    }

    public boolean loginUser(String email, String password){
        User user = findUserByEmail(email);
        if(user.getPassword().equals(password)) {
            redisRespository.save(email, user.getNickname());
            return true;
        } else return false;
    }

    public boolean logoutUser(String email){
        return redisRespository.delete(email);
    }

    public User getUser(String email){
        return findUserByEmail(email);
    }

    private User findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
