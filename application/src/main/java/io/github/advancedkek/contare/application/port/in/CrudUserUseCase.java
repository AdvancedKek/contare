package io.github.advancedkek.contare.application.port.in;

import io.github.advancedkek.contare.domain.User;

import java.util.List;
import java.util.UUID;

public interface CrudUserUseCase {
    List<User> getById(UUID id);
    List<User> get();
    User create(User user);
    User update(User user);
    void delete(UUID id);
}
