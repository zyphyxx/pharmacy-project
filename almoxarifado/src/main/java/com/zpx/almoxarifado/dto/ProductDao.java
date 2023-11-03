package com.zpx.almoxarifado.dto;

import com.zpx.almoxarifado.domain.Produto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@Component
public class ProductDao {

    private Long id;
    private String nome;
    private String descricao;

    public ProductDao(Produto produto){
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
    }
}
