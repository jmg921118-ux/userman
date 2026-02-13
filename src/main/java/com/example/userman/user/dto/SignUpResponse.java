package com.example.userman.user.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class SignUpResponse {

    private  Long id;
    private  String username;
    private  String email;
    private  LocalDateTime createdAt;
    private  LocalDateTime modifiedAt;


    }

