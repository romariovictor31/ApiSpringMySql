package com.example.apiSpringSimple.controller;

import com.example.apiSpringSimple.medico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid DataRegisterMed dados) {
            repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, page = 0, sort = {"nome"}) Pageable pagination) {
        return repository.findAll(pagination).map(DadosListagemMedico::new);
    };

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid DataUpdateMed dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.updateData(dados);
    }

    @DeleteMapping("/{id}") //DELETE FOR DINAMIC PARAMETER
    @Transactional
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
