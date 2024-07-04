package io.github.advancedkek.contare.infrastructure.out.h2;

import io.github.advancedkek.contare.application.port.out.EmployerStorage;
import io.github.advancedkek.contare.domain.Employer;
import io.github.advancedkek.contare.domain.exception.EmployerNotFoundException;
import io.github.advancedkek.contare.infrastructure.out.h2.convert.EmployerEntityConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CrudEmployerUseCaseImpl implements EmployerStorage {

    private final EmployerRepository employerRepository;

    @Override
    public List<Employer> find(UUID id) {
        return employerRepository.findById(id)
                .map(EmployerEntityConverter::toDomain)
                .stream().toList();
    }

    @Override
    public List<Employer> get() {
        return employerRepository.findAll().stream()
                .map(EmployerEntityConverter::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Employer create(Employer employer) {
        var newEntity = employerRepository.save(EmployerEntityConverter.toEntity(employer));
        return EmployerEntityConverter.toDomain(newEntity);
    }

    @Override
    public Employer update(Employer employer) {
        var isEmployerExist = employerRepository.existsById(employer.getId());
        if (!isEmployerExist) {
            var message = String.format("Employer with ID %s not found", employer.getId());
            throw new EmployerNotFoundException(message);
        }
        employerRepository.save(EmployerEntityConverter.toEntity(employer));
        return employer;
    }

    @Override
    public void delete(UUID id) {
        employerRepository.deleteById(id);
    }
}