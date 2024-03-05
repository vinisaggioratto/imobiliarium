package com.vgs.imobiliarium.controller;

import com.vgs.imobiliarium.dto.CadastroDTO;
import com.vgs.imobiliarium.service.CadastroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {

    @Autowired
    private CadastroService service;

    @GetMapping
    public ResponseEntity getAll() {
        try {
            return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[Error displaying all activities.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[Erro ao buscar cadastro por id.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid CadastroDTO cadastro) {
        try {
            return new ResponseEntity<>(service.save(cadastro), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("[Erro ao salvar novo cadastro.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
