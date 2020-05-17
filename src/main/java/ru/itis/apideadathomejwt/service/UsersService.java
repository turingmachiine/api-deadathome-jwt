package ru.itis.apideadathomejwt.service;

import ru.itis.apideadathomejwt.dto.UserDto;

import java.util.List;

public interface UsersService {
    List<UserDto> getUsers();

    UserDto getConcreteUser(Long userId);

    List<UserDto> search(String name);
}
