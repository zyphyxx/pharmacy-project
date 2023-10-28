package com.zpx.pharmacy.model;

import com.zpx.pharmacy.dto.DadosCadastroRemedio;
import com.zpx.pharmacy.enums.Laboratorio;
import com.zpx.pharmacy.enums.Via;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "remedy")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Remedio {

    public Remedio(DadosCadastroRemedio dados) {
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
    private String quantidade;
    private String validade;

    @Enumerated(EnumType.STRING)
    private Laboratorio laboratorio;

}