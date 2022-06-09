package dev.phellipe.springsocial.application.rest.domain.response.user;

import dev.phellipe.springsocial.domain.entity.user.User;
import dev.phellipe.springsocial.domain.enums.AuthProvider;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private UUID id;

    private String name;

    private String email;

    private String imageUrl;

    private Boolean emailVerified = false;

    private AuthProvider provider;

    private String providerId;

    public static UserResponse from(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .imageUrl(user.getImageUrl())
                .emailVerified(user.getEmailVerified())
                .provider(user.getProvider())
                .providerId(user.getProviderId())
                .build();
    }
}
