package ru.itis.apideadathomejwt.service;

import ru.itis.apideadathomejwt.dto.PostDto;

import java.util.List;

public interface PostsService {
    List<PostDto> getPosts();

    PostDto getConcretePost(Long postId);

    List<PostDto> search(String name);

}
