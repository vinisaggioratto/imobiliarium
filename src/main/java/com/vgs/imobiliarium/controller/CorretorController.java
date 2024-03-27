package com.vgs.imobiliarium.controller;

import com.vgs.imobiliarium.dto.CorretorDTO;
import com.vgs.imobiliarium.service.CorretorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/corretor")
public class CorretorController {

    @Autowired
    private CorretorService service;

    @GetMapping
    public ResponseEntity getAll() {
        try {
            return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[Erro ao exibir todos os corretores cadastradas.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[Erro ao buscar corretor por id.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid CorretorDTO corretor) {
        try {
            return new ResponseEntity<>(service.save(corretor), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("[Erro ao salvar novo corretor.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity put(@RequestBody @Valid CorretorDTO corretor){
        try {
            return new ResponseEntity<>(service.update(corretor), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("[Erro ao atualizar corretor.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        try {
            return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("[Erro ao deletar corretor.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
