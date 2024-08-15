package io.github.advancedkek.contare.application.port.out;

import io.github.advancedkek.contare.domain.User;

import java.util.List;
import java.util.UUID;

public interface UserStorage {
    List<User> find(UUID id);
    List<User> get();
    User create(User user);
    User update(User user);
    void delete(UUID id);
}
