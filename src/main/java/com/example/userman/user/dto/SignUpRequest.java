package com.example.userman.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class SignUpRequest {
    @NotBlank
    private String username;
    @Email
    private String email;
    @Size(min = 8, max = 16)
    private String password;

}
