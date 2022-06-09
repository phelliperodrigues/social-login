package dev.phellipe.springsocial.infrastructure.security.oauth2.user;

import java.util.Map;
import lombok.Getter;

public abstract class OAuth2UserInfo {
    @Getter
    protected Map<String, Object> attributes;

    protected OAuth2UserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public abstract String getId();

    public abstract String getName();

    public abstract String getEmail();

    public abstract String getImageUrl();
}