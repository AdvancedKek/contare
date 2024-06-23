package io.github.advancedkek.contare.infrastructure.out.h2.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.UUID;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    String firstName;
    String lastName;
    String patronymic;
    String phone;
    String address;
    String email;
}