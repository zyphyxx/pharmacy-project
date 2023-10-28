package com.zpx.pharmacy.dto;

import com.zpx.pharmacy.enums.Laboratorio;
import com.zpx.pharmacy.enums.Via;
import com.zpx.pharmacy.model.Remedio;

import java.time.LocalDate;

public record DadosListagemRemedio(String nome, Via via, String lote, Laboratorio laboratorio, LocalDate validade) {

    public DadosListagemRemedio(Remedio remedio){
      this(remedio.getNome(), remedio.getVia(),remedio.getLote(),remedio.getLaboratorio(),remedio.getValidade());
    }
}
