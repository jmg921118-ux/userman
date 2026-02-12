package com.example.userman.user.dto;

import lombok.Getter;

@Getter
public class UpdateNameResponse {

    private final String username;

    public UpdateNameResponse(String username) {
        this.username = username;
    }
}
