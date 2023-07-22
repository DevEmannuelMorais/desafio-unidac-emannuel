package com.emannuel.organizecafe.organizecafe.model.dto;



import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.io.Serializable;
import java.time.LocalDate;


public record CoffeeDTO(@NotNull(message = "O dia marcado não pode está null")
                        //@Past(message = "Data é inválida.")
                        LocalDate coffeeDate,
                        @NotNull(message = "O campo item não pode está null")
                        @NotEmpty(message = "O campo item não pode está vazio")
                        String coffeeItem,
                        @NotNull(message = "O id do colaborador não pode está null")
                        Long collaborator_id,
                        Boolean realized) implements Serializable {

}
