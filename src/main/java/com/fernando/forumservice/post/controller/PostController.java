package com.fernando.forumservice.post.controller;

import com.fernando.forumservice.exception.BadRequestExceptionDetails;
import com.fernando.forumservice.exception.NotFoundExceptionDetails;
import com.fernando.forumservice.post.facade.PostFacade;
import com.fernando.forumservice.post.model.request.PostCreationRequest;
import com.fernando.forumservice.post.model.request.PostUpdateRequest;
import com.fernando.forumservice.post.model.response.PostResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Cria um post")
    @ApiResponses({
            @ApiResponse(code = 201, message = "CREATED", response = PostResponse.class),
            @ApiResponse(code = 400, message = "NOT FOUND", response = NotFoundExceptionDetails.class),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR", response = Exception.class)
    })
    public PostResponse create(@RequestBody @Valid @NotNull PostCreationRequest post) {
        return postFacade.create(post);
    }

    @GetMapping("/posts")
    @ResponseStatus(HttpStatus.FOUND)
    @ApiOperation("Busca todos os posts")
    @ApiResponses({
            @ApiResponse(code = 302, message = "FOUND", response = PostResponse[].class),
            @ApiResponse(code = 400, message = "NOT FOUND", response = NotFoundExceptionDetails.class),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR", response = Exception.class)
    })
    public List<PostResponse> findAll() {
        return postFacade.findAll();
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.FOUND)
    @ApiOperation("Busca por um post")
    @ApiResponses({
            @ApiResponse(code = 302, message = "FOUND", response = PostResponse.class),
            @ApiResponse(code = 400, message = "NOT FOUND", response = NotFoundExceptionDetails.class),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR", response = Exception.class)
    })
    public PostResponse findById(@RequestParam String id) {
        return postFacade.findById(id);
    }

    @PutMapping("/update")
    @ApiOperation("Atualiza um post")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = PostResponse.class),
            @ApiResponse(code = 400, message = "NOT FOUND", response = NotFoundExceptionDetails.class),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR", response = Exception.class)
    })
    public PostResponse update(@RequestBody @Valid @NotNull PostUpdateRequest postUpdateRequest) {
        return postFacade.update(postUpdateRequest);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Atualiza um post")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = PostResponse.class),
            @ApiResponse(code = 404, message = "BAD REQUEST", response = BadRequestExceptionDetails.class),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR", response = Exception.class)
    })
    public void delete(@RequestParam @Valid @NotNull String id, @RequestParam @Valid @NotNull String username) {
        postFacade.delete(id, username);
    }
}
