package com.fernando.forumservice.post.service;

import com.fernando.forumservice.exception.NotFoundException;
import com.fernando.forumservice.post.entity.PostEntity;
import com.fernando.forumservice.post.mapper.PostMapper;
import com.fernando.forumservice.post.model.PostModel;
import com.fernando.forumservice.post.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public PostModel createPost(PostModel post) {
        return Optional.of(postRepository.save(PostMapper.mapToEntity(post)))
                .map(PostMapper::mapToModel)
                .orElseThrow(() -> new RuntimeException("falha ao salvar usuario"));
    }

    public List<PostModel> findAll() {
        return Optional.of(postRepository.findAll())
                .map(PostMapper::mapToModelList)
                .orElseThrow(() -> new NotFoundException("Nenhum post encontrado"));
    }
}
