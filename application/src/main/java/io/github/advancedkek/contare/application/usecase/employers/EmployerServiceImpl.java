package io.github.advancedkek.contare.application.usecase.employers;

import io.github.advancedkek.contare.application.port.in.CrudEmployerUseCase;
import io.github.advancedkek.contare.application.port.out.EmployerStorage;
import io.github.advancedkek.contare.domain.Employer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployerServiceImpl implements CrudEmployerUseCase {

    private final EmployerStorage employerStorage;

    @Override
    public List<Employer> getById(UUID id) {
        return employerStorage.find(id);
    }

    @Override
    public List<Employer> get() {
        return employerStorage.get();
    }

    @Override
    public Employer create(Employer employer) {
        return employerStorage.create(employer);
    }

    @Override
    public Employer update(Employer employer) {
        return employerStorage.update(employer);
    }

    @Override
    public void delete(UUID id) {
        employerStorage.delete(id);
    }
}
