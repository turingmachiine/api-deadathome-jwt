package ru.itis.apideadathomejwt.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.apideadathomejwt.dto.HousesDto;
import ru.itis.apideadathomejwt.dto.PostDto;
import ru.itis.apideadathomejwt.dto.UserDto;
import ru.itis.apideadathomejwt.service.HousesService;
import ru.itis.apideadathomejwt.service.PostsService;
import ru.itis.apideadathomejwt.service.UsersService;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class CoursesController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private HousesService housesService;

    @Autowired
    private PostsService postsService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUsers(@RequestParam(value = "id", required = false)Long id, @RequestParam(value = "name", required = false) String name) {
        log.info("Get users request");
        if (id != null) {
            return ResponseEntity.ok(Arrays.asList(usersService.getConcreteUser(id)));
        } else if (name != null) {
            return ResponseEntity.ok(usersService.search(name));
        } else {
            return ResponseEntity.ok(usersService.getUsers());
        }
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/houses")
    public List<HousesDto> getHouses(@RequestParam(value = "id", required = false)Long id, @RequestParam(value = "name", required = false) String name) {
        log.info("Get users request");
        if (id != null) {
            return Arrays.asList(housesService.getConcreteHouse(id));
        } else if (name != null) {
            return housesService.search(name);
        } else {
            return housesService.getHouses();
        }
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/posts")
    public List<PostDto> getPosts(@RequestParam(value = "id", required = false)Long id, @RequestParam(value = "name", required = false) String name) {
        log.info("Get users request");
        if (id != null) {
            return Arrays.asList(postsService.getConcretePost(id));
        } else if (name != null) {
            return postsService.search(name);
        } else {
            return postsService.getPosts();
        }
    }

}
