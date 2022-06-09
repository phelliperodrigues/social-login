package dev.phellipe.springsocial.infrastructure.database.postgres.mapper;

import dev.phellipe.springsocial.domain.entity.user.User;
import dev.phellipe.springsocial.infrastructure.database.postgres.entity.UserModel;

public class UserModelMapper {

    private UserModelMapper() {
        throw new IllegalStateException("UserModelMapper is a Utility class");
    }

    public static User convert(UserModel model) {
        return User.builder()
                .id(model.getId())
                .name(model.getName())
                .email(model.getEmail())
                .imageUrl(model.getImageUrl())
                .emailVerified(model.getEmailVerified())
                .password(model.getPassword())
                .provider(model.getProvider())
                .providerId(model.getProviderId())
                .build();
    }

    public static UserModel convert(User user) {
        return UserModel.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .imageUrl(user.getImageUrl())
                .emailVerified(user.getEmailVerified())
                .password(user.getPassword())
                .provider(user.getProvider())
                .providerId(user.getProviderId())
                .build();
    }
}
