package com.fernando.forumservice.post.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentRequest {

    @ApiModelProperty(value = "Nome do autor", example = "Eliton Dioni", required = true)
    @NotBlank(message = "O nome do autor não pode estar vazio")
    private String author;
    @ApiModelProperty(value = "Mensagem do comentário", required = true)
    @NotBlank(message = "A mensagem do comentário não pode estar vazia")
    private String body;
}
