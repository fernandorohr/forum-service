package com.fernando.forumservice.email.controller;

import com.fernando.forumservice.email.facade.EmailFacade;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/v1/email")
@AllArgsConstructor
public class EmailController {

    private final EmailFacade emailFacade;

    @PostMapping("/send")
    @ApiOperation("Envia um email para o destino passado")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = Void.class),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR", response = Exception.class)
    })
    public void sendEmail(@RequestParam @Valid @NotBlank String destination) {
        emailFacade.sendEmail(destination);
    }
}
