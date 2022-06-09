package dev.phellipe.springsocial.application.rest.domain.request.user;

import dev.phellipe.springsocial.domain.entity.user.User;
import dev.phellipe.springsocial.domain.enums.AuthProvider;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private UUID id;
    private String name;

    private String email;

    private String imageUrl;

    private Boolean emailVerified = false;

    private String password;

    private AuthProvider provider;

    private String providerId;

    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .imageUrl(imageUrl)
                .emailVerified(emailVerified)
                .password(password)
                .provider(provider)
                .providerId(providerId)
                .build();
    }

}
