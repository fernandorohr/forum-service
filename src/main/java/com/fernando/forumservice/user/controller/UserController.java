package com.fernando.forumservice.user.controller;

import com.fernando.forumservice.exception.BadRequestException;
import com.fernando.forumservice.exception.NotFoundException;
import com.fernando.forumservice.exception.PreConditionFailedException;
import com.fernando.forumservice.user.facade.UserFacade;
import com.fernando.forumservice.user.model.request.LoginRequest;
import com.fernando.forumservice.user.model.request.UserRequest;
import com.fernando.forumservice.user.model.response.UserResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/v1/user")
@AllArgsConstructor
public class UserController {

    private final UserFacade userFacade;

    @PostMapping("/create")
    @ApiOperation("Cria um usuário")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = UserResponse.class),
            @ApiResponse(code = 412, message = "PRECONDITION FAILED", response = PreConditionFailedException.class),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR", response = Exception.class)
    })
    public UserResponse create(@RequestBody @Valid @NotNull UserRequest userRequest) {
        return userFacade.create(userRequest);
    }

    @PutMapping("/update")
    @ApiOperation("Atualiza um usuário")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = UserResponse.class),
            @ApiResponse(code = 404, message = "NOT FOUND", response = NotFoundException.class),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR", response = Exception.class)
    })
    public UserResponse update(@RequestBody @Valid @NotNull UserRequest userRequest) {
        return userFacade.update(userRequest);
    }

    @GetMapping("/login")
    @ApiOperation("Faz o login de um usuário")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = UserResponse.class),
            @ApiResponse(code = 400, message = "NOT FOUND", response = BadRequestException.class),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR", response = Exception.class)
    })
    public UserResponse login(@RequestBody @Valid @NotNull LoginRequest loginRequest) {
        return userFacade.login(loginRequest);
    }

    @DeleteMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Deleta um usuário")
    @ApiResponses({
            @ApiResponse(code = 204, message = "NO CONTENT", response = Void.class),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR", response = Exception.class)
    })
    public void delete(@RequestParam @Valid @NotBlank String username) {
        userFacade.delete(username);
    }
}
