package com.vgs.imobiliarium.service;

import com.vgs.imobiliarium.dto.CadastroDTO;
import com.vgs.imobiliarium.entity.Cadastro;
import com.vgs.imobiliarium.repository.CadastroRepository;
import com.vgs.imobiliarium.viewdto.CadastroViewDTO;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CadastroService {

    @Autowired
    private CadastroRepository repository;

    private ModelMapper mapper = new ModelMapper();

    public List<CadastroViewDTO> getAll() {
        return repository.findAll().stream().map(
                cadastro -> new CadastroViewDTO(
                        cadastro.getId(), cadastro.getNome(), cadastro.getSobrenome(), cadastro.getCpfCnpj(),
                        cadastro.getRg(), cadastro.getDataNascimento(), cadastro.getEmail(), cadastro.getTelefoneCelular(),
                        cadastro.getSexo(), cadastro.getCadastroAtivo(), cadastro.getRua(), cadastro.getNumero(),
                        cadastro.getBairro(), cadastro.getCidade(), cadastro.getCep(), cadastro.getEstado(),
                        cadastro.getDataCadastro(), cadastro.getDataUpdate()
                )
        ).collect(Collectors.toList());
    }

    public CadastroViewDTO getById(Long id) {
        Optional<Cadastro> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Cadastro não localizado.");
        }
        Cadastro cadastro = optional.get();
        return new CadastroViewDTO(
                cadastro.getId(), cadastro.getNome(), cadastro.getSobrenome(), cadastro.getCpfCnpj(),
                cadastro.getRg(), cadastro.getDataNascimento(), cadastro.getEmail(), cadastro.getTelefoneCelular(),
                cadastro.getSexo(), cadastro.getCadastroAtivo(), cadastro.getRua(), cadastro.getNumero(),
                cadastro.getBairro(), cadastro.getCidade(), cadastro.getCep(), cadastro.getEstado(),
                cadastro.getDataCadastro(), cadastro.getDataUpdate());
    }

    @Transactional
    public CadastroViewDTO save(CadastroDTO cadastro) {
        cadastro.setDataCadastro(LocalDateTime.now());
        cadastro.setDataUpdate(LocalDateTime.now());
        Cadastro cadSave = mapper.map(cadastro, Cadastro.class);
        repository.save(cadSave);
        return new CadastroViewDTO(
                cadastro.getId(), cadastro.getNome(), cadastro.getSobrenome(), cadastro.getCpfCnpj(),
                cadastro.getRg(), cadastro.getDataNascimento(), cadastro.getEmail(), cadastro.getTelefoneCelular(),
                cadastro.getSexo(), cadastro.getCadastroAtivo(), cadastro.getRua(), cadastro.getNumero(),
                cadastro.getBairro(), cadastro.getCidade(), cadastro.getCep(), cadastro.getEstado(),
                cadastro.getDataCadastro(), cadastro.getDataUpdate());
    }

    @Transactional
    public CadastroViewDTO update(CadastroDTO cadastro){
        cadastro.setDataUpdate(LocalDateTime.now());
        Cadastro cadSave = mapper.map(cadastro, Cadastro.class);
        Optional<Cadastro> optional = repository.findById(cadastro.getId());
        if (!optional.isPresent()){
            throw new RuntimeException("Cadastro não localizado.");
        }
        repository.save(cadSave);
        return new CadastroViewDTO(
                cadastro.getId(), cadastro.getNome(), cadastro.getSobrenome(), cadastro.getCpfCnpj(),
                cadastro.getRg(), cadastro.getDataNascimento(), cadastro.getEmail(), cadastro.getTelefoneCelular(),
                cadastro.getSexo(), cadastro.getCadastroAtivo(), cadastro.getRua(), cadastro.getNumero(),
                cadastro.getBairro(), cadastro.getCidade(), cadastro.getCep(), cadastro.getEstado(),
                cadastro.getDataCadastro(), cadastro.getDataUpdate()
        );
    }

    @Transactional
    public String delete(Long id){
        Optional<Cadastro> optional = repository.findById(id);
        if (!optional.isPresent()){
            throw new RuntimeException("Cadastro não localizado.");
        }
        Cadastro cadSave = optional.get();
        cadSave.setCadastroAtivo(false);
        repository.save(cadSave);
        return "Cadastro desativado com sucesso.";
    }
}
