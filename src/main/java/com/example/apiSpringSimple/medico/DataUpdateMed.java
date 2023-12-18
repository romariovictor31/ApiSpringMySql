package com.example.apiSpringSimple.medico;

import com.example.apiSpringSimple.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DataUpdateMed(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
