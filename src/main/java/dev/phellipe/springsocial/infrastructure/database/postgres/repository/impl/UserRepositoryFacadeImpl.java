package dev.phellipe.springsocial.infrastructure.database.postgres.repository.impl;

import dev.phellipe.springsocial.domain.entity.user.User;
import dev.phellipe.springsocial.domain.repository.UserRepositoryFacade;
import dev.phellipe.springsocial.infrastructure.database.postgres.mapper.UserModelMapper;
import dev.phellipe.springsocial.infrastructure.database.postgres.repository.jpa.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class UserRepositoryFacadeImpl implements UserRepositoryFacade {

    private final UserRepository repository;

    public UserRepositoryFacadeImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User save(User entity) {
        var model = repository.save(UserModelMapper.convert(entity));
        return UserModelMapper.convert(model);
    }

    @Override
    public Optional<User> findById(UUID id) {
        return repository.findById(id).map(UserModelMapper::convert);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll().stream().map(UserModelMapper::convert).toList();
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(User entity) {
        repository.delete(UserModelMapper.convert(entity));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email).map(UserModelMapper::convert);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }
}
