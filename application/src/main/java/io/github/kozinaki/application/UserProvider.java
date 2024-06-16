package io.github.kozinaki.application;

import io.github.kozinaki.domain.User;

import java.util.UUID;

public interface UserProvider {
    User find(UUID id);

    User save(User user);

    void delete(UUID id);
}
