package ru.itis.apideadathomejwt.dto;

import lombok.Data;

@Data
public class SignInDto {
    private String email;
    private String password;
}
