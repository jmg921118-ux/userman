package com.example.userman.user.service;

import com.example.userman.user.dto.*;
import com.example.userman.user.entity.User;
import com.example.userman.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    //유저 생성
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
    // 로그인
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
    // 단건 조회
    @Transactional(readOnly = true)
    public GetUserResponse getOne (Long userId){
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("없는 유저입니다^^")
        );
        return new GetUserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getModifiedAt()
        );

    }

    public List<GetUserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();

        List<GetUserResponse>dtos = new ArrayList<>();
        for(User user : users) {
            GetUserResponse dto = new GetUserResponse(
                    user.getId(),
                    user.getUsername(),
                    user.getEmail(),
                    user.getCreatedAt(),
                    user.getModifiedAt()
            );
            dtos.add(dto);

        }
        return dtos;
    }

    public UpdateNameResponse updateUser(Long userId, UpdateNameResponse request) {

        return null;
    }

    public void deleteUser(Long userId) {
    }
}
