package com.vgs.imobiliarium.controller;

import com.vgs.imobiliarium.dto.CadastroDTO;
import com.vgs.imobiliarium.dto.InquilinoDTO;
import com.vgs.imobiliarium.service.InquilinoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inquilino")
public class InquilinoController {

    @Autowired
    private InquilinoService service;

    @GetMapping
    public ResponseEntity getAll() {
        try {
            return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[Erro ao exibir todos os inquilinos.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[Erro ao buscar inquilino por id.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid InquilinoDTO inquilino) {
        try {
            return new ResponseEntity<>(service.save(inquilino), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("[Erro ao salvar novo inquilino.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity put(@RequestBody @Valid InquilinoDTO inquilino) {
        try {
            return new ResponseEntity<>(service.update(inquilino), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[Erro ao atualizar inquilino.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[Erro ao desativar inquilino.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
