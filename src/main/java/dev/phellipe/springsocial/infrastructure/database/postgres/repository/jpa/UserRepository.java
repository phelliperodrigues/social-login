package dev.phellipe.springsocial.infrastructure.database.postgres.repository.jpa;

import dev.phellipe.springsocial.infrastructure.database.postgres.entity.UserModel;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
    Optional<UserModel> findByEmail(String email);

    Boolean existsByEmail(String email);
}