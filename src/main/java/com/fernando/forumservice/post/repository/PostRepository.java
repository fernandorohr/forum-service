package com.fernando.forumservice.post.repository;

import com.fernando.forumservice.post.entity.PostEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<PostEntity, String> {

}
