package com.zpx.pharmacy.dto;

import com.zpx.pharmacy.enums.Laboratorio;
import com.zpx.pharmacy.enums.Via;
import com.zpx.pharmacy.model.Remedio;

import java.time.LocalDate;

public record DadosDetalhamentoRemedio(Long id,
                                       String nome,
                                       Via via,
                                       String lote,
                                       Integer quantidade,
                                       LocalDate validade,
                                       Laboratorio laboratorio,
                                       Boolean ativo) {

    public DadosDetalhamentoRemedio(Remedio remedio){
        this(remedio.getId(),
                remedio.getNome(),
                remedio.getVia(),
                remedio.getLote(),
                remedio.getQuantidade(),
                remedio.getValidade(),
                remedio.getLaboratorio(),
                remedio.getAtivo());
    }
}
