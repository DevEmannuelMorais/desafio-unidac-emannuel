package com.emannuel.organizecafe.organizecafe.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public record CollaboratorUpdateDTO(
        @NotNull(message = "O campo cpf não pode está null")
        @Size(max = 11, min = 11, message = "\"O cpf deve ter no máximo {max} caracteres e no minimo"
                + "{min} caracteres. Você digitou: " + "${validatedValue}" )
        @CPF(message = "'${validatedValue}' é inválido!")
        String cpf,
        @NotNull( message = "O campo name não pode ser null")
        @NotEmpty(message = "O campo name não pode está vazio")
        @Size(min = 3, max =40, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
        String name)  {
}
