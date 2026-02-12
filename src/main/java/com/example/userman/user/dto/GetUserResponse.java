package com.example.userman.user.dto;


import lombok.Getter;

@Getter

public class GetUserResponse {

    private final Long id;
    private final String email;
    private final String password;


    public GetUserResponse(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
}
