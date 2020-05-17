package ru.itis.apideadathomejwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.apideadathomejwt.models.House;
import ru.itis.apideadathomejwt.models.Post;
import ru.itis.apideadathomejwt.models.User;

import java.util.List;
import java.util.Optional;

public interface PostsRepository extends JpaRepository<Post, Long> {
    Optional<Post> findByTitleIgnoreCase(String title);
    List<Post> findByAuthor(User author);
    List<Post> findByHouse(House house);
    List<Post> findByHouseAndIdIsNot(House house, Long id);
    List<Post> findByTitleContainsIgnoreCase(String name);
}
