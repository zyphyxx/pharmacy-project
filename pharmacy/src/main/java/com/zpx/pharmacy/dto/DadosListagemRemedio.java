package com.zpx.pharmacy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zpx.pharmacy.enums.Laboratorio;
import com.zpx.pharmacy.enums.Via;
import com.zpx.pharmacy.model.Remedio;

import java.time.LocalDate;

public record DadosListagemRemedio(
        @JsonProperty("id") Long id,
        @JsonProperty("nome") String nome,
        @JsonProperty("via") Via via,
        @JsonProperty("lote") String lote,
        @JsonProperty("quantidade") Integer quantidade,
        @JsonProperty("validade") LocalDate validade,
        @JsonProperty("laboratorio") Laboratorio laboratorio
) {
    public DadosListagemRemedio(Remedio remedio) {
        this(
                remedio.getId(),
                remedio.getNome(),
                remedio.getVia(),
                remedio.getLote(),
                remedio.getQuantidade(),
                remedio.getValidade(),
                remedio.getLaboratorio()
        );
    }
}
