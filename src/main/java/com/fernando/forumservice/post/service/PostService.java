package com.fernando.forumservice.post.service;

import com.fernando.forumservice.exception.BadRequestException;
import com.fernando.forumservice.exception.NotFoundException;
import com.fernando.forumservice.post.factory.PostFactory;
import com.fernando.forumservice.post.mapper.PostMapper;
import com.fernando.forumservice.post.model.PostModel;
import com.fernando.forumservice.post.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final PostFactory postFactory;

    public PostModel save(PostModel post) {
        return Optional.of(postRepository.save(PostMapper.mapToEntity(post)))
                .map(PostMapper::mapToModel)
                .orElseThrow(() -> new RuntimeException("falha ao salvar post"));
    }

    public List<PostModel> findAll() {
        return Optional.of(postRepository.findAll())
                .map(PostMapper::mapToModelList)
                .orElseThrow(() -> new NotFoundException("Nenhum post encontrado"));
    }

    public PostModel findById(String id) {
        return postRepository.findById(id)
                .map(PostMapper::mapToModel)
                .orElseThrow(() -> new NotFoundException("Post não encontrado"));
    }

    public PostModel update(PostModel requestPost) {
        return postRepository.findById(getId(requestPost))
                .map(PostMapper::mapToModel)
                .map(databasePost -> postFactory.updatePost(requestPost, databasePost))
                .map(this::save)
                .orElseThrow(() -> new NotFoundException("Post não encontrado"));

    }

    public void delete(String id) {
        postRepository.delete(PostMapper.mapToEntity(findById(id)));
    }

    private String getId(PostModel post) {
        return Optional.ofNullable(post)
                .map(PostModel::getId)
                .orElseThrow(() -> new BadRequestException("ID do post é obrigatório na atualização"));
    }
}
