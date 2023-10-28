package com.zpx.pharmacy.controller;

import com.zpx.pharmacy.dto.DadosCadastroRemedio;
import com.zpx.pharmacy.dto.DadosListagemRemedio;
import com.zpx.pharmacy.model.Remedio;
import com.zpx.pharmacy.repository.RemedyRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/remedio")
public class RemedioController {


    @Autowired
    private RemedyRepository repository;

    @GetMapping
    public List<DadosListagemRemedio> listar(){
        return repository.findAll().stream().map(DadosListagemRemedio ::new).toList();
    }


    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroRemedio dados) {
        repository.save(new Remedio(dados));

    }


}
