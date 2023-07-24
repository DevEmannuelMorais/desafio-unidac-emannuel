package com.emannuel.organizecafe.organizecafe.model.dto;


import java.time.LocalDate;


public record CoffeeUpdateDTO(
        String coffeeItem, LocalDate coffeeDate,
        Boolean realized) {
}
