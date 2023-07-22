package com.emannuel.organizecafe.organizecafe.model.dto;

import com.emannuel.organizecafe.organizecafe.model.Collaborator;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record CoffeeDTO(LocalDate coffeeDate, String coffeeItem,
                        Long collaborator_id,
                        Boolean realized) implements Serializable {

}
