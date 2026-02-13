package com.example.userman.user.controller;

import com.example.userman.user.dto.*;
import com.example.userman.user.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    // 회원 가입
    @PostMapping("/signup")
    public ResponseEntity<SignUpResponse> SignUp(@RequestBody SignUpRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(request));

    }
    // 로그인
    @PostMapping("/login")
    public ResponseEntity<Void> Login(@RequestBody LogInRequest request, HttpSession session) {
        SessionLogin sessionLogin = userService.login(request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    // 유저 id 조회
    @GetMapping("users/{userId}")
    public ResponseEntity<GetUserResponse> Users(@PathVariable Long userId) {
        GetUserResponse getUserResponse = userService.getOne(userId);
        return ResponseEntity.status(HttpStatus.OK).body(getUserResponse);
    }

    @GetMapping("/users")
    public ResponseEntity<List<GetUserResponse>> getAllUsers() {
        List<GetUserResponse> userList = userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(userList);
    }

    // 유저 정보 수정
    @PutMapping("/users/{userId}")
    public ResponseEntity<UpdateNameResponse> updateUser(
            @PathVariable Long userId,
            @RequestBody UpdateNameResponse request) {
        UpdateNameResponse updatedUser = userService.updateUser(userId, request);
        return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
    }

    // 유저 삭제
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 삭제 성공 시 204 No Content 반환
    }
}
