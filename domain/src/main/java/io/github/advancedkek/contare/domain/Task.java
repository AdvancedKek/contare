package io.github.advancedkek.contare.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class Task {
    UUID id;
    UUID employerId;
    String name;
    String description;
    String price;
    String employeePrice;
    String servicePrice;
}
