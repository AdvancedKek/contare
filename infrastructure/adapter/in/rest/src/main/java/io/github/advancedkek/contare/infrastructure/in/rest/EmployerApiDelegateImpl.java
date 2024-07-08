package io.github.advancedkek.contare.infrastructure.in.rest;

import io.github.advancedkek.contare.api.EmployerApiDelegate;
import io.github.advancedkek.contare.api.model.CreateEmployerRequest;
import io.github.advancedkek.contare.api.model.EmployerResponse;
import io.github.advancedkek.contare.api.model.EmployersResponse;
import io.github.advancedkek.contare.api.model.UpdateEmployerRequest;
import io.github.advancedkek.contare.application.port.in.CrudEmployerUseCase;
import io.github.advancedkek.contare.infrastructure.in.rest.convert.EmployerApiConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployerApiDelegateImpl implements EmployerApiDelegate {

    private final CrudEmployerUseCase employerUseCase;

    @Override
    public ResponseEntity<EmployerResponse> addEmployer(CreateEmployerRequest createEmployerRequest) {
        var employer = employerUseCase.create(EmployerApiConverter.toDomain(createEmployerRequest));
        return ResponseEntity.ok(
                new EmployerResponse(
                        EmployerApiConverter.toApi(employer)
                )
        );
    }

    @Override
    public ResponseEntity<Void> deleteEmployer(UUID id) {
        employerUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<EmployersResponse> getEmployerById(UUID id) {
        var employers = Optional.ofNullable(id)
                .map(employerUseCase::getById)
                .orElse(employerUseCase.get());
        var employersResponse = new EmployersResponse(employers.stream()
                .map(EmployerApiConverter::toApi)
                .collect(Collectors.toList()));
        return ResponseEntity.ok(employersResponse);
    }

    @Override
    public ResponseEntity<EmployerResponse> updateEmployer(UpdateEmployerRequest updateEmployerRequest) {
        var employer = employerUseCase.update(EmployerApiConverter.toDomain(updateEmployerRequest));
        return ResponseEntity.ok(
                new EmployerResponse(
                        EmployerApiConverter.toApi(employer)
                )
        );
    }
}