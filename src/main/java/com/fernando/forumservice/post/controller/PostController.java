package com.fernando.forumservice.post.controller;

import com.fernando.forumservice.post.facade.PostFacade;
import com.fernando.forumservice.post.model.request.PostCreationRequest;
import com.fernando.forumservice.post.model.request.PostUpdateRequest;
import com.fernando.forumservice.post.model.response.CommentResponse;
import com.fernando.forumservice.post.model.response.PostResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/v1/post")
@AllArgsConstructor
public class PostController {

    private final PostFacade postFacade;

    @PostMapping("/create")
    public PostResponse create(@RequestBody @Valid @NotNull PostCreationRequest post) {
        return postFacade.create(post);
    }

    @GetMapping("/posts")
    public List<PostResponse> findAll() {
        return postFacade.findAll();
    }

    @GetMapping()
    public PostResponse findById(@RequestParam String id) {
        return null;
        //TODO implementar o fluxo de chamar um post por id
    }

    @PutMapping("/update")
    public PostResponse update(@RequestBody @Valid @NotNull PostUpdateRequest post) {
        return null;
        //TODO Implementar o fluxo de atualização de post
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam String id) {
        //TODO implementar o fluxo de deleção de post
    }

    @PutMapping("/add-like")
    public Integer addLike(@RequestParam String id) {
        return null;
        //TODO implementar o fluxo de dar like
    }

    @PutMapping("/remove-like")
    public Integer removeLike(@RequestParam String id) {
        return null;
        //TODO implementar o fluxo de remover like
    }

    @PutMapping("/add-comment")
    public CommentResponse addComment(@RequestParam String id) {
        return null;
        //TODO implementar o fluxo para adicionar um comentário
    }
}
