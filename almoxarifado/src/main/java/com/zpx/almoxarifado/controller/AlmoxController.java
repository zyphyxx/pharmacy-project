package com.zpx.almoxarifado.controller;


import com.zpx.almoxarifado.domain.Produto;
import com.zpx.almoxarifado.repository.AlmoxRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product1")
public class AlmoxController {

    @Autowired
    public AlmoxRepository almoxRepository;

    @PostMapping
    @Transactional
    public void criarCadastro(@RequestBody Produto produto){
       almoxRepository.save(produto);
    }

   @GetMapping
    public List<Produto>ListarProduto (){
        return almoxRepository.findAll();
   }

   @PutMapping
   @Transactional
    public Produto atualizarProduto(@RequestBody Produto produto){
        return almoxRepository.save(produto);
   }

   @DeleteMapping
    public void apagarProduto (@RequestBody Produto produto){
        almoxRepository.delete(produto);
   }
}
