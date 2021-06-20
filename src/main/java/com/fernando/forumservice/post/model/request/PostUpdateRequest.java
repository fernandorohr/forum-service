package com.fernando.forumservice.post.model.request;

import com.fernando.forumservice.post.enums.PostTags;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostUpdateRequest {

    @ApiModelProperty(value = "Id do mongo", example = "60ce4e15fa49ac5f6a20a2fa", required = true)
    @NotBlank(message = "O id do mongo não pode estar vazio")
    private String id;
    @ApiModelProperty(value = "Nome do autor", example = "Eliton Dioni", required = true)
    @NotBlank(message = "O nome do autor não pode estar vazio")
    private String author;
    @ApiModelProperty(value = "Título do post", example = "Um novo amanhã", required = true)
    @NotBlank(message = "O título do post não pode estar vazio")
    private String title;
    @ApiModelProperty(value = "Texto do post", required = true)
    @NotBlank(message = "O post precisa de pelo menos um texto")
    private String body;
    @ApiModelProperty(value = "Tags do post", example = "[ENSINO, ESTUDO_CIENTIFICO]")
    private List<PostTags> tags;
}
