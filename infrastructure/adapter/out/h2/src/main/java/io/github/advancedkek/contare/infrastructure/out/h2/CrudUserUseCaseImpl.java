package io.github.advancedkek.contare.infrastructure.out.h2;

import io.github.advancedkek.contare.application.port.out.UserStorage;
import io.github.advancedkek.contare.domain.User;
import io.github.advancedkek.contare.domain.exception.UserNotFoundException;
import io.github.advancedkek.contare.infrastructure.out.h2.convert.UserEntityConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CrudUserUseCaseImpl implements UserStorage {

    private final UserRepository userRepository;

    @Override
    public List<User> find(UUID id) {
        return userRepository.findById(id)
                .map(UserEntityConverter::toDomain)
                .stream().toList();
    }

    @Override
    public List<User> get() {
        return userRepository.findAll().stream()
                .map(UserEntityConverter::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public User create(User user) {
        var newEntity = userRepository.save(UserEntityConverter.toEntity(user));
        return UserEntityConverter.toDomain(newEntity);
    }

    @Override
    public User update(User user) {
        var isUserExist = userRepository.existsById(user.getId());
        if (!isUserExist) {
            var message = String.format("User with ID %s not found", user.getId());
            throw new UserNotFoundException(message);
        }
        userRepository.save(UserEntityConverter.toEntity(user));
        return user;
    }

    @Override
    public void delete(UUID id) {
        userRepository.deleteById(id);
    }
}