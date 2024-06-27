package io.github.advancedkek.contare.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class Employer {
    UUID id;
    String firstName;
    String lastName;
    String patronymic;
    String phone;
    String address;
    String email;
}
