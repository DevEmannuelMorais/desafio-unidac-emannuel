package com.emannuel.organizecafe.organizecafe.model.dto;

import com.emannuel.organizecafe.organizecafe.model.Collaborator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record CoffeeUpdateDTO(
        String coffeeItem, LocalDate coffeeDate,
        Boolean realized) {
}
