package com.fernando.forumservice.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fernando.forumservice.post.enums.PostTags;
import com.fernando.forumservice.user.enums.UserRole;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "users")
public class UserEntity {

    @Id
    private String id;
    private String name;
    private String username;
    private UserRole role;
    private String password;
    private String email;
    private Boolean firstLogin;
    private List<PostTags> likedTags;
    private List<String> likedPosts;
    private List<String> posts;
}
