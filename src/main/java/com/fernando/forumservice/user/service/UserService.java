package com.fernando.forumservice.user.service;

import com.fernando.forumservice.exception.BadRequestException;
import com.fernando.forumservice.exception.NotFoundException;
import com.fernando.forumservice.exception.PreConditionFailedException;
import com.fernando.forumservice.post.model.PostModel;
import com.fernando.forumservice.user.factory.UserFactory;
import com.fernando.forumservice.user.mapper.UserMapper;
import com.fernando.forumservice.user.model.UserModel;
import com.fernando.forumservice.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserFactory userFactory;

    public UserModel findByUsername(String username) {
        return Optional.ofNullable(userRepository.findByUsername(username))
                .map(UserMapper::mapToModel)
                .orElseThrow(() -> new NotFoundException("Nenhum usuario achado"));
    }

    public UserModel save(UserModel userModel) {
        return Optional.of(userRepository.save(UserMapper.mapToEntity(userModel)))
                .map(UserMapper::mapToModel)
                .orElseThrow(() -> new RuntimeException("Falha ao salvar usuario"));
    }

    public UserModel create(UserModel userModel) {
        if (!ObjectUtils.isEmpty(userRepository.findByUsernameOrEmail(userModel.getUsername(), userModel.getEmail())))
            throw new PreConditionFailedException("Usuário ja cadastrado");
        userModel.setFirstLogin(true);
        return save(userModel);
    }

    public UserModel update(UserModel userModel) {
         return Optional.ofNullable(userRepository.findByUsername(userModel.getUsername()))
                 .map(UserMapper::mapToModel)
                 .map(user -> userFactory.updateUser(userModel, user))
                 .map(this::save)
                 .orElseThrow(() -> new NotFoundException("Usuario não encontrado"));
    }

    public UserModel login(UserModel userModel) {
        return Optional.ofNullable(userRepository.findByEmailAndPassword(userModel.getEmail(), userModel.getPassword()))
                .map(UserMapper::mapToModel)
                .orElseThrow(() -> new BadRequestException("Email ou senha errados!"));
    }

    public void delete(String username) {
        userRepository.deleteByUsername(username);
    }

    public void addPost(String username, String postId) {
        Optional.ofNullable(findByUsername(username))
                .map(user -> newPostList(user, postId))
                .map(this::save)
                .orElseThrow(() -> new NotFoundException("Usuario não encontrado"));
    }

    public void deletePost(String postId, String username) {
        Optional.ofNullable(findByUsername(username))
                .map(userModel -> removePost(userModel, postId))
                .map(this::save);
    }

    private UserModel removePost(UserModel user, String id) {
        if (!user.getPosts().remove(id))
            throw new PreConditionFailedException("Post não encontrado no usuário");
        return user;
    }

    private UserModel newPostList(UserModel user, String newPost) {
        user.getPosts().add(newPost);
        return user;
    }
}
