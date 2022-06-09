package dev.phellipe.springsocial.domain.usecase.auth;

import dev.phellipe.springsocial.domain.entity.auth.SignUp;
import dev.phellipe.springsocial.domain.entity.user.User;
import dev.phellipe.springsocial.domain.enums.AuthProvider;
import dev.phellipe.springsocial.domain.exception.BadRequestException;
import dev.phellipe.springsocial.domain.repository.UserRepositoryFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Register {

    private final UserRepositoryFacade userRepository;
    private final PasswordEncoder passwordEncoder;

    public User execute(SignUp signUp) {

        if (userRepository.existsByEmail(signUp.getEmail())) {
            throw new BadRequestException("Email address already in use.");
        }

        return userRepository.save(User.builder()
                .name(signUp.getName())
                .email(signUp.getEmail())
                .password(passwordEncoder.encode(signUp.getPassword()))
                .provider(AuthProvider.local)
                .build());
    }
}
