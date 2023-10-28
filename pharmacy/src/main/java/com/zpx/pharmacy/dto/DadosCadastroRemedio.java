package com.zpx.pharmacy.dto;

import com.zpx.pharmacy.enums.Laboratorio;
import com.zpx.pharmacy.enums.Via;

public record DadosCadastroRemedio(String nome,
                                   Via via,
                                   String lote,
                                   String quantidade,
                                   String validade,
                                   Laboratorio laboratorio) {
}
