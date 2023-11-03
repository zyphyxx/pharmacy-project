package com.zpx.almoxarifado.controller;

import com.zpx.almoxarifado.dto.ProductDao;
import com.zpx.almoxarifado.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class ProductController {

    private final ProductService service;

    @Autowired
    ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProductDao> listarProdutos() {
        return service.listarProduto();
    }

    @GetMapping("/{id}")
    public Optional<ProductDao> listarPorId(@PathVariable Long id) {
        return service.encontrarPeloId(id);
    }

}
