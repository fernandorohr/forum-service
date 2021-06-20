package com.fernando.forumservice.user.model.request;

import com.fernando.forumservice.post.enums.PostTags;
import com.fernando.forumservice.user.enums.UserRole;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {

    @ApiModelProperty(value = "Nome do usuário", example = "Fernando Rohr", required = true)
    @NotBlank(message = "O nome não pode vir vazio")
    private String name;
    @ApiModelProperty(value = "Nick do usuário", example = "fernandorohr", required = true)
    @NotBlank(message = "O username não pode vir vazio")
    private String username;
    @ApiModelProperty(value = "Nível de acesso do usuário", example = "ADM/COMMON", required = true)
    @NotNull(message = "O nível de acesso não pode vir vazio")
    private UserRole role;
    @NotBlank(message = "A senha não pode vir vazio")
    @ApiModelProperty(value = "Senha do usário", example = "123_@#abc", required = true)
    private String password;
    @ApiModelProperty(value = "E-mail do usuário", example = "fernando@gmail.com", required = true)
    @Email
    @NotBlank(message = "O e-mail não pode vir vazio")
    private String email;
    @ApiModelProperty(value = "Lista de tags favoritas do usuário", example = "[ENSINO, ESTUDO_CIENTIFICO]")
    private List<PostTags> likedTags;
    @ApiModelProperty(value = "Lista de posts favoritos do usuário usando id do mongo",
            example = "[60ce4e15fa49ac5f6a20a2fa, 60cf6c0da77a152fd5d88137]")
    private List<String> likedPosts;
    @ApiModelProperty(value = "Lista de posts do usuário usando id do mongo",
            example = "[60ce4e15fa49ac5f6a20a2fa, 60cf6c0da77a152fd5d88137]")
    private List<String> posts;
}
