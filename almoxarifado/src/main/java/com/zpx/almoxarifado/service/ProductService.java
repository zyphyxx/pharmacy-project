package com.zpx.almoxarifado.service;

import com.zpx.almoxarifado.domain.Produto;
import com.zpx.almoxarifado.dto.ProductDao;
import com.zpx.almoxarifado.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<ProductDao> listarProduto() {
        List<Produto> produtos = repository.findAll();
        return produtos.stream()
                .map(ProductDao::new).toList();
    }

    public Optional<ProductDao> encontrarPeloId (Long id){
        return repository.findById(id).map(ProductDao::new);
    }

}
