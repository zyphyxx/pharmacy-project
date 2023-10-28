package com.zpx.pharmacy.controller;

import com.zpx.pharmacy.dto.DadosCadastroRemedio;
import com.zpx.pharmacy.model.Remedio;
import com.zpx.pharmacy.repository.RemedyRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/remedio")
public class RemedioController {


    @Autowired
    private RemedyRepository repository;

    @GetMapping
    public String ola(){
        return "<h1>Boa tarde</h1>";
    }


    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroRemedio dados) {
        repository.save(new Remedio(dados));

    }


}
