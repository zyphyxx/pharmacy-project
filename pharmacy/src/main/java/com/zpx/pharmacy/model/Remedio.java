package com.zpx.pharmacy.model;

import com.zpx.pharmacy.dto.DadosAtualizarRemedio;
import com.zpx.pharmacy.dto.DadosCadastroRemedio;
import com.zpx.pharmacy.enums.Laboratorio;
import com.zpx.pharmacy.enums.Via;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "remedio")
@Table(name = "remedio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Remedio {

    public Remedio(DadosCadastroRemedio dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.via = dados.via();
        this.lote = dados.lote();
        this.quantidade = dados.quantidade();
        this.validade = dados.validade();
        this.laboratorio = dados.laboratorio();

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nome;

    @Enumerated(EnumType.STRING)
    private Via via;

    private String lote;
    private Integer quantidade;
    private LocalDate validade;
    private Boolean ativo;

    @Enumerated(EnumType.STRING)
    private Laboratorio laboratorio;

    public void atualizarInformacoes(@Valid DadosAtualizarRemedio dados) {
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.via() != null){
            this.via = dados.via();
        }
        if (dados.lote() != null){
            this.lote = dados.lote();
        }
        if (dados.quantidade() != 0) {
            this.quantidade = dados.quantidade();
        }
        if (dados.validade() != null){
            this.validade = dados.validade();
        }
        if (dados.laboratorio() != null){
            this.laboratorio = dados.laboratorio();
        }
    }

    public void inativar(Long id) {
        this.ativo = false;
    }

    public void reativar(Long id) {
        this.ativo = true;
    }
}
