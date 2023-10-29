package com.zpx.pharmacy.dto;

import com.zpx.pharmacy.enums.Laboratorio;
import com.zpx.pharmacy.enums.Via;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosAtualizarRemedio(@NotNull Long id,
                                    String nome, Via via, String lote, Integer quantidade, LocalDate validade,
                                    Laboratorio laboratorio) {

}
