package com.example.apiSpringSimple.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(

        @NotBlank
        String logradouro,

        @NotBlank
        String bairro,

        @NotBlank
        @Pattern(regexp = "\\d{8}") //8 digitos (d) que compoem o cep
        String cep,

        @NotBlank
        String cidade,

        @NotBlank
        String uf,

        String numero,

        String complemento) {
}



/*Por ser uma classe que será tanto usada para medico quanto
para paciente, foi feito um novo package para endereco.
 */