package com.zpx.pharmacy.controller;

import com.zpx.pharmacy.dto.DadosCadastroRemedio;
import com.zpx.pharmacy.model.Remedio;
import com.zpx.repository.RemedyRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/remedios")
public class RemedioController {

    // o erro esta aqui
    @Autowired
    private RemedyRepository repository;


    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroRemedio dados) {
        repository.save(new Remedio(dados));

    }


}
