package io.github.kozinaki.infrastructure.postgres;

import io.github.kozinaki.application.UserProvider;
import io.github.kozinaki.domain.User;

import java.util.UUID;

public class UserProviderImpl implements UserProvider {
    @Override
    public User find(UUID id) {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void delete(UUID id) {
    }
}