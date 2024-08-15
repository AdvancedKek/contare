package io.github.advancedkek.contare.infrastructure.in.rest;

import io.github.advancedkek.contare.api.UserApiDelegate;
import io.github.advancedkek.contare.api.model.CreateUserRequest;
import io.github.advancedkek.contare.api.model.UserResponse;
import io.github.advancedkek.contare.api.model.UsersResponse;
import io.github.advancedkek.contare.api.model.UpdateUserRequest;
import io.github.advancedkek.contare.application.port.in.CrudUserUseCase;
import io.github.advancedkek.contare.infrastructure.in.rest.convert.UserApiConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserApiDelegateImpl implements UserApiDelegate {

    private final CrudUserUseCase userUseCase;

    @Override
    public ResponseEntity<UserResponse> addUser(CreateUserRequest createUserRequest) {
        var user = userUseCase.create(UserApiConverter.toDomain(createUserRequest));
        return ResponseEntity.ok(
                new UserResponse(
                        UserApiConverter.toApi(user)
                )
        );
    }

    @Override
    public ResponseEntity<Void> deleteUser(UUID id) {
        userUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<UsersResponse> getUserById(UUID id) {
        var users = Optional.ofNullable(id)
                .map(userUseCase::getById)
                .orElse(userUseCase.get());
        var usersResponse = new UsersResponse(users.stream()
                .map(UserApiConverter::toApi)
                .collect(Collectors.toList()));
        return ResponseEntity.ok(usersResponse);
    }

    @Override
    public ResponseEntity<UserResponse> updateUser(UpdateUserRequest updateUserRequest) {
        var user = userUseCase.update(UserApiConverter.toDomain(updateUserRequest));
        return ResponseEntity.ok(
                new UserResponse(
                        UserApiConverter.toApi(user)
                )
        );
    }
}