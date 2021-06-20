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
public class PostCreationRequest {

    @ApiModelProperty(value = "Nick do usuário que fez o post", example = "fernandorohr", required = true)
    @NotBlank(message = "O nick do autor do post não pode estar vazio")
    private String username;
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
