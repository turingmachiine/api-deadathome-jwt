package ru.itis.apideadathomejwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.apideadathomejwt.models.User;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByConfirmCode(String confirmCode);
    List<User> findAllByFirstNameOrLastNameContainsIgnoreCase(String firstName, String lastName);
}
