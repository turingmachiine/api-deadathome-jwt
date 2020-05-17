package ru.itis.apideadathomejwt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.apideadathomejwt.dto.SignInDto;
import ru.itis.apideadathomejwt.dto.TokenDto;
import ru.itis.apideadathomejwt.service.SignInService;

@RestController
public class SignInController {


    @Autowired
    private SignInService signInService;

    @PostMapping("/signIn")
    public ResponseEntity<TokenDto> signIn(@RequestBody SignInDto signInData) {
        return ResponseEntity.ok(signInService.signIn(signInData));
    }
}
