package ru.itis.apideadathomejwt.service;

import ru.itis.apideadathomejwt.dto.SignInDto;
import ru.itis.apideadathomejwt.dto.TokenDto;

public interface SignInService {
    TokenDto signIn(SignInDto signInData);
}
