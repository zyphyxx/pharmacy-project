package com.zpx.pharmacy.dto;

import com.zpx.pharmacy.enums.Laboratorio;
import com.zpx.pharmacy.enums.Via;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;


import java.time.LocalDate;

public record DadosCadastroRemedio(


        @NotBlank
        String nome,
        @Enumerated
        Via via,
        @NotBlank
        String lote,

        Integer quantidade,

        @Future
        LocalDate validade,
        @Enumerated
        Laboratorio laboratorio) {
}
