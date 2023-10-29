package com.zpx.pharmacy.controller;

import com.zpx.pharmacy.dto.DadosAtualizarRemedio;
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

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroRemedio dados) {
        repository.save(new Remedio(dados));

    }

    @GetMapping
    public List<DadosListagemRemedio> listar() {
        return repository.findAll().stream().map(DadosListagemRemedio::new).toList();
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarRemedio dados) {
        var remedio = repository.getReferenceById(dados.id());
        remedio.atualizarInformacoes(dados);
    }


}
