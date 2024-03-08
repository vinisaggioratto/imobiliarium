package com.vgs.imobiliarium.controller;

import com.vgs.imobiliarium.dto.CadastroDTO;
import com.vgs.imobiliarium.dto.UsuariosDTO;
import com.vgs.imobiliarium.service.UsuariosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService service;

    @GetMapping
    public ResponseEntity getAll() {
        try {
            return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[Erro ao exibir todos os usuários.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[Erro ao buscar usuário por id.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid UsuariosDTO usuarios) {
        try {
            return new ResponseEntity<>(service.save(usuarios), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("[Erro ao salvar novo usuário.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity put(@RequestBody @Valid UsuariosDTO usuarios){
        try {
            return new ResponseEntity<>(service.update(usuarios), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("[Erro ao atualizar usuário.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        try {
            return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("[Erro ao deletar usuário.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
