package dev.phellipe.springsocial.infrastructure.security.factory;


import dev.phellipe.springsocial.domain.enums.AuthProvider;
import dev.phellipe.springsocial.domain.exception.OAuth2AuthenticationProcessingException;
import dev.phellipe.springsocial.infrastructure.security.oauth2.user.FacebookOAuth2UserInfo;
import dev.phellipe.springsocial.infrastructure.security.oauth2.user.GithubOAuth2UserInfo;
import dev.phellipe.springsocial.infrastructure.security.oauth2.user.GoogleOAuth2UserInfo;
import dev.phellipe.springsocial.infrastructure.security.oauth2.user.OAuth2UserInfo;
import java.util.Map;

public class OAuth2UserInfoFactory {

    private OAuth2UserInfoFactory() {
        throw new IllegalStateException("OAuth2UserInfoFactory is a Factory class");
    }

    public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
        if (registrationId.equalsIgnoreCase(AuthProvider.google.toString())) {
            return new GoogleOAuth2UserInfo(attributes);
        } else if (registrationId.equalsIgnoreCase(AuthProvider.facebook.toString())) {
            return new FacebookOAuth2UserInfo(attributes);
        } else if (registrationId.equalsIgnoreCase(AuthProvider.github.toString())) {
            return new GithubOAuth2UserInfo(attributes);
        } else {
            throw new OAuth2AuthenticationProcessingException("Sorry! Login with " + registrationId + " is not supported yet.");
        }
    }
}