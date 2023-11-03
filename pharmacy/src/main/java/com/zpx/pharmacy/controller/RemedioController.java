package com.zpx.pharmacy.controller;

import com.zpx.pharmacy.dto.DadosAtualizarRemedio;
import com.zpx.pharmacy.dto.DadosCadastroRemedio;
import com.zpx.pharmacy.dto.DadosDetalhamentoRemedio;
import com.zpx.pharmacy.dto.DadosListagemRemedio;
import com.zpx.pharmacy.model.Remedio;
import com.zpx.pharmacy.repository.RemedyRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/remedio")
public class RemedioController {


    @Autowired
    private RemedyRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoRemedio> cadastrar(@RequestBody @Valid DadosCadastroRemedio dados, UriComponentsBuilder uriBuilder) {
        var remedio = new Remedio(dados);
        repository.save(remedio);

        var uri = uriBuilder.path("/remedios/{id}").buildAndExpand(remedio.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoRemedio(remedio));

    }

    @GetMapping
    public ResponseEntity<List<DadosListagemRemedio>> listar() {
        var lista = repository.findAllByAtivoTrue().stream().map(DadosListagemRemedio::new).toList();

        return ResponseEntity.ok(lista);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoRemedio> atualizar(@RequestBody @Valid DadosAtualizarRemedio dados) {
        var remedio = repository.getReferenceById(dados.id());
        remedio.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoRemedio(remedio));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("inativar/{id}")
    @Transactional
    public ResponseEntity<Void> inativar(@PathVariable Long id) {
        var remedio = repository.getReferenceById(id);
        remedio.inativar(remedio.getId());

        return ResponseEntity.noContent().build();
    }

    @PutMapping("reativar/{id}")
    @Transactional
    public ResponseEntity<Void> reativar(@PathVariable Long id) {
        var remedio = repository.getReferenceById(id);
        remedio.reativar(remedio.getId());

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoRemedio> detalhar (@PathVariable Long id) {
        var remedio = repository.getReferenceById(id);


        return ResponseEntity.ok(new DadosDetalhamentoRemedio(remedio));
    }


}
