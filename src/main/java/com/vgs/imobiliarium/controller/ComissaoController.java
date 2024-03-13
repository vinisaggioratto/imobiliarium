package com.vgs.imobiliarium.controller;

import com.vgs.imobiliarium.dto.ComissaoDTO;
import com.vgs.imobiliarium.service.ComissaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comissao")
public class ComissaoController {

    @Autowired
    private ComissaoService service;

    @GetMapping
    public ResponseEntity getAll() {
        try {
            return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[Erro ao exibir todas as comissões cadastradas.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("[Erro ao buscar comissão por id.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid ComissaoDTO comissao) {
        try {
            return new ResponseEntity<>(service.save(comissao), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("[Erro ao salvar nova comissão.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity put(@RequestBody @Valid ComissaoDTO comissao){
        try {
            return new ResponseEntity<>(service.update(comissao), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("[Erro ao atualizar comissão.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        try {
            return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("[Erro ao deletar comissão.] - " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
