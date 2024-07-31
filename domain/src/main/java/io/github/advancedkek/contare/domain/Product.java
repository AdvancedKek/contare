package io.github.advancedkek.contare.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
public class Product {
    UUID id;
    String name;
    String description;
    String price;
}
