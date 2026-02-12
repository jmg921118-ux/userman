package com.example.userman.user.controller;

import com.example.userman.user.dto.*;
import com.example.userman.user.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponse> SignUp(@RequestBody SignUpRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(request));

    }

    @PostMapping("/login")
    public ResponseEntity<Void> Login(@RequestBody LogInRequest request, HttpSession session) {
        SessionLogin sessionLogin = userService.login(request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("users/{userId}")
    public ResponseEntity<GetUserResponse> Users(@PathVariable Long userId) {
        GetUserResponse getUserResponse = userService.getOne(userId);
        return ResponseEntity.status(HttpStatus.OK).body(getUserResponse);
    }
    @Getter
}
