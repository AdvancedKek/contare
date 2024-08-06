package io.github.advancedkek.contare.application.usecase.user;

import io.github.advancedkek.contare.application.port.in.CrudUserUseCase;
import io.github.advancedkek.contare.application.port.out.UserStorage;
import io.github.advancedkek.contare.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements CrudUserUseCase {

    private final UserStorage userStorage;

    @Override
    public List<User> getById(UUID id) {
        return userStorage.find(id);
    }

    @Override
    public List<User> get() {
        return userStorage.get();
    }

    @Override
    public User create(User user) {
        return userStorage.create(user);
    }

    @Override
    public User update(User user) {
        return userStorage.update(user);
    }

    @Override
    public void delete(UUID id) {
        userStorage.delete(id);
    }
}
