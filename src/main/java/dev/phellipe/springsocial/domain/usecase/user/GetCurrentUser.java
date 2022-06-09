package dev.phellipe.springsocial.domain.usecase.user;

import dev.phellipe.springsocial.domain.entity.user.User;
import dev.phellipe.springsocial.domain.exception.ResourceNotFoundException;
import dev.phellipe.springsocial.domain.repository.UserRepositoryFacade;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetCurrentUser {

    private final UserRepositoryFacade userRepository;

    public User execute(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }
}
