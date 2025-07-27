package com.ms.user.dtos;

import com.ms.user.models.Documento;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserDto(
        @NotBlank String name,
        @NotBlank @Email String email,
        DocumentoDto documento
) {
}

 record DocumentoDto(
        String rg,
        String cpf,
        String cnpj
) {}