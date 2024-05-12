package com.choiye.awspractice.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RedisRespository {
    private final RedisTemplate redisTemplate;

    public void save(String email, String nickname){
        redisTemplate.opsForValue().set(email,nickname);
    }
    public boolean delete(String email){
        return Boolean.TRUE.equals(redisTemplate.delete(email));
    }
}
