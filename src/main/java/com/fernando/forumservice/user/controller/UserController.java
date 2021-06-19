package com.fernando.forumservice.user.controller;

import com.fernando.forumservice.user.model.request.LoginRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.fernando.forumservice.user.facade.UserFacade;
import com.fernando.forumservice.user.model.request.UserRequest;
import com.fernando.forumservice.user.model.response.UserResponse;

@RestController
@RequestMapping("/v1/user")
@AllArgsConstructor
public class UserController {

    private final UserFacade userFacade;

    @PostMapping("/create")
    public UserResponse create(@RequestBody UserRequest userRequest) {
        return userFacade.create(userRequest);
    }

    @PutMapping("/update")
    public UserResponse update(@RequestBody UserRequest userRequest) {
        return userFacade.update(userRequest);
    }

    @GetMapping("/login")
    public UserResponse login(@RequestBody LoginRequest loginRequest) {
        return userFacade.login(loginRequest);
    }

    @DeleteMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestParam String username) {
        userFacade.delete(username);
    }
}
