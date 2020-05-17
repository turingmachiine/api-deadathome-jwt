package ru.itis.apideadathomejwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.apideadathomejwt.dto.PostDto;
import ru.itis.apideadathomejwt.repository.PostsRepository;

import java.util.List;

import static ru.itis.apideadathomejwt.dto.PostDto.from;

@Service
public class PostsServiceImpl implements PostsService {

    @Autowired
    private PostsRepository postsRepository;

    @Override
    public List<PostDto> getPosts() {
        return from(postsRepository.findAll());
    }

    @Override
    public PostDto getConcretePost(Long postId) {
        return from(postsRepository.getOne(postId));
    }

    @Override
    public List<PostDto> search(String name) {
        return from(postsRepository.findByTitleContainsIgnoreCase(name));
    }

}
