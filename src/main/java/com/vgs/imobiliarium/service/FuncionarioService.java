package com.vgs.imobiliarium.service;

import com.vgs.imobiliarium.dto.FuncionarioDTO;
import com.vgs.imobiliarium.entity.Funcionario;
import com.vgs.imobiliarium.repository.FuncionarioRepository;
import com.vgs.imobiliarium.viewdto.FuncionarioViewDTO;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    private ModelMapper mapper = new ModelMapper();

    public List<FuncionarioViewDTO> getAll() {
        return repository.findAll().stream().map(
                funcionario -> new FuncionarioViewDTO(
                        funcionario.getId(), funcionario.getCadastro(), funcionario.getSalario(),
                        funcionario.getFuncao(), funcionario.getData_admissao(), funcionario.getData_demissao(),
                        funcionario.getCadastro_ativo(), funcionario.getUsuario()
                )
        ).collect(Collectors.toList());
    }

    public FuncionarioViewDTO getById(Long id) {
        Optional<Funcionario> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Funcionário não localizado.");
        }
        Funcionario funcionario = optional.get();
        return new FuncionarioViewDTO(
                funcionario.getId(), funcionario.getCadastro(), funcionario.getSalario(),
                funcionario.getFuncao(), funcionario.getData_admissao(), funcionario.getData_demissao(),
                funcionario.getCadastro_ativo(), funcionario.getUsuario()
        );
    }

    @Transactional
    public FuncionarioViewDTO save(FuncionarioDTO funcionario) {
        funcionario.setDataCadastroFuncionario(LocalDateTime.now());
        funcionario.setDataUpdateFuncionario(LocalDateTime.now());
        Funcionario funSave = mapper.map(funcionario, Funcionario.class);
        repository.save(funSave);

        return new FuncionarioViewDTO(
                funcionario.getId(), funcionario.getCadastro(), funcionario.getSalario(),
                funcionario.getFuncao(), funcionario.getData_admissao(), funcionario.getData_demissao(),
                funcionario.getCadastro_ativo(), funcionario.getUsuario()
        );
    }

    @Transactional
    public FuncionarioViewDTO update(FuncionarioDTO funcionario) {

        Optional<Funcionario> optional = repository.findById(funcionario.getId());
        if (!optional.isPresent()) {
            throw new RuntimeException("Funcionário não localizado.");
        }
        funcionario.setDataUpdateFuncionario(LocalDateTime.now());
        Funcionario funSave = mapper.map(funcionario, Funcionario.class);

        repository.save(funSave);
        return new FuncionarioViewDTO(
                funcionario.getId(), funcionario.getCadastro(),funcionario.getSalario(),
                funcionario.getFuncao(), funcionario.getData_admissao(), funcionario.getData_demissao(),
                funcionario.getCadastro_ativo(), funcionario.getUsuario()
        );
    }

    @Transactional
    public String delete(Long id) {
        Optional<Funcionario> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Funcionário não localizado.");
        }
        Funcionario funSave = optional.get();
        funSave.setDataUpdateFuncionario(LocalDateTime.now());
        funSave.setCadastro_ativo(false);
        repository.save(funSave);
        return "Funcionário desativado com sucesso.";
    }
}
