package ru.itis.apideadathomejwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.apideadathomejwt.dto.UserDto;
import ru.itis.apideadathomejwt.models.User;
import ru.itis.apideadathomejwt.repository.UsersRepository;

import java.util.List;

import static ru.itis.apideadathomejwt.dto.UserDto.from;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<UserDto> getUsers() {
        return from(usersRepository.findAll());
    }

    @Override
    public UserDto getConcreteUser(Long userId) {
        User user = usersRepository.getOne(userId);
        return from(user);
    }

    @Override
    public List<UserDto> search(String name) {
        return from(usersRepository.findAllByFirstNameOrLastNameContainsIgnoreCase(name, name));
    }
}
