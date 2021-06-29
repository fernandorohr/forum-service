package com.fernando.forumservice.post.facade;

import com.fernando.forumservice.post.mapper.PostMapper;
import com.fernando.forumservice.post.model.PostModel;
import com.fernando.forumservice.post.model.request.PostCreationRequest;
import com.fernando.forumservice.post.model.request.PostUpdateRequest;
import com.fernando.forumservice.post.model.response.PostResponse;
import com.fernando.forumservice.post.service.PostService;
import com.fernando.forumservice.user.model.UserModel;
import com.fernando.forumservice.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@AllArgsConstructor
public class PostFacade {

    private final PostService postService;
    private final UserService userService;

    public PostResponse create(PostCreationRequest postCreationRequest) {
        UserModel user = userService.findByUsername(postCreationRequest.getUsername());
        PostModel newPost = postService.save(PostMapper.mapToModel(postCreationRequest));
        user.getPosts().add(newPost.getId());
        userService.save(user);
        return PostMapper.mapToResponse(newPost);
    }

    public List<PostResponse> findAll() {
        List<PostModel> posts = postService.findAll();
        Collections.sort(posts);
        return PostMapper.mapToResponselList(posts);
    }

    public PostResponse findById(String id) {
        return PostMapper.mapToResponse(postService.findById(id));
    }

    public PostResponse update(PostUpdateRequest postUpdateRequest) {
        return PostMapper.mapToResponse(postService.update(PostMapper.mapToModel(postUpdateRequest)));
    }

    public void delete(String id, String username) {
        userService.deletePost(id, username);
        postService.delete(id);
    }
}
