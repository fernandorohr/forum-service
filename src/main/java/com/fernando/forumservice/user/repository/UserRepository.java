package com.fernando.forumservice.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.fernando.forumservice.user.entity.UserEntity;

public interface UserRepository extends MongoRepository<UserEntity, String> {

    UserEntity findByUsername(String username);

    UserEntity findByEmailAndPassword(String email, String password);

    void deleteByUsername(String username);
}
