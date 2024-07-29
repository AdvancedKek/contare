package io.github.advancedkek.contare.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class Provider {
    UUID id;
    String name;
    String phone;
    String address;
    String email;
}
