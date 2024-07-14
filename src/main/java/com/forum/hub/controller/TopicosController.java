package com.forum.hub.controller;


import com.forum.hub.domain.topicos.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    TopicosRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity novoTopico(@RequestBody @Valid DadosNovoTopico dados, UriComponentsBuilder uriBuilder) {

        var topico = new Topicos(dados);
        repository.save(topico);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopicos(topico));


    }


    @GetMapping
    public Page<DadosListagemTopicos> listagemTopicos(@PageableDefault(size = 10, sort ={"dataCriacao"}, direction = Sort.Direction.ASC)Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemTopicos::new);

    }


    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoTopicos(topico));
    }


}