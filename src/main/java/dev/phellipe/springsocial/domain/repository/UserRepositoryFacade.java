package dev.phellipe.springsocial.domain.repository;

import dev.phellipe.springsocial.domain.entity.user.User;
import java.util.Optional;

public interface UserRepositoryFacade extends CrudRepository<User> {
    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);
}
