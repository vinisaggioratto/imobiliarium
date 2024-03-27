package com.vgs.imobiliarium.controller;

import com.vgs.imobiliarium.dto.CadastroDTO;
import com.vgs.imobiliarium.dto.ClienteDTO;
import com.vgs.imobiliarium.entity.Cliente;
import com.vgs.imobiliarium.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public ResponseEntity getAll() {
        try {
            return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[Erro ao exibir todos os clientes.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[Erro ao buscar cliente por id.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid ClienteDTO cliente) {
        try {
            return new ResponseEntity<>(service.save(cliente), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("[Erro ao salvar novo cliente.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity put(@RequestBody @Valid ClienteDTO cliente) {
        try {
            return new ResponseEntity<>(service.update(cliente), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[Erro ao atualizar cliente.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[Erro ao desativar cliente.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
