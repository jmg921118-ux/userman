package com.example.userman.user.service;

import com.example.userman.user.dto.*;
import com.example.userman.user.entity.User;
import com.example.userman.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public SignUpResponse save(SignUpRequest request) {
        User user = new User(
                request.getUsername(),
                request.getEmail(),
                request.getPassword()
        );
        User saveduser = userRepository.save(user);
        return new SignUpResponse(
                saveduser.getId(),
                saveduser.getUsername(),
                saveduser.getEmail(),
                saveduser.getCreatedAt(),
                saveduser.getModifiedAt()
        );

    }

    @Transactional(readOnly = true)
    public SessionLogin login(LogInRequest request) {
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(
                () -> new IllegalStateException("없는 이메일입니다. 이메일 확인 후 다시 로그인 해주세요.")
        );
        return new SessionLogin(
                user.getId(),
                user.getEmail(),
                user.getPassword()
        );


    }
    @Transactional(readOnly = true)
    public GetUserResponse getOne (Long userId){
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("없는 유저입니다^^")
        );
        return new GetUserResponse(
                user.getId(),
                user.getEmail(),
                user.getPassword()
        );

    }

}