package com.vgs.imobiliarium.service;

import com.vgs.imobiliarium.dto.UsuariosDTO;
import com.vgs.imobiliarium.entity.Usuarios;
import com.vgs.imobiliarium.repository.UsuariosRepository;
import com.vgs.imobiliarium.security.SecurityConfig;
import com.vgs.imobiliarium.viewdto.UsuariosViewDTO;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepository repository;
    private ModelMapper mapper = new ModelMapper();

    public List<UsuariosViewDTO> getAll() {
        return repository.findAll().stream().map(
                usuarios -> new UsuariosViewDTO(
                        usuarios.getId(), usuarios.getUsername(), usuarios.getCadastro(), usuarios.getCadastroAtivo())
        ).collect(Collectors.toList());
    }

    public UsuariosViewDTO getById(Long id) {
        Optional<Usuarios> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Usuário não localizado.");
        }
        Usuarios usuarios = optional.get();
        return new UsuariosViewDTO(
                usuarios.getId(), usuarios.getUsername(), usuarios.getCadastro(), usuarios.getCadastroAtivo());
    }

    @Transactional
    public UsuariosViewDTO save(UsuariosDTO usuarios) {
        usuarios.setPassword(SecurityConfig.passwordEncoder().encode(usuarios.getPassword()));
        Usuarios usuSave = mapper.map(usuarios, Usuarios.class);
        repository.save(usuSave);
        return new UsuariosViewDTO(
                usuarios.getId(), usuarios.getUsername(), usuarios.getCadastro(), usuarios.getCadastroAtivo());
    }

    @Transactional
    public UsuariosViewDTO update(UsuariosDTO usuarios){
        usuarios.setPassword(SecurityConfig.passwordEncoder().encode(usuarios.getPassword()));
        Usuarios usuSave = mapper.map(usuarios, Usuarios.class);
        Optional<Usuarios> optional = repository.findById(usuarios.getId());
        if (!optional.isPresent()){
            throw new RuntimeException("Usuário não localizado.");
        }
        repository.save(usuSave);
        return new UsuariosViewDTO(
                usuarios.getId(), usuarios.getUsername(), usuarios.getCadastro(), usuarios.getCadastroAtivo());
    }

    @Transactional
    public String delete(Long id){
        Optional<Usuarios> optional = repository.findById(id);
        if (!optional.isPresent()){
            throw new RuntimeException("Usuário não localizado.");
        }
        Usuarios usuarios = optional.get();
        usuarios.setCadastroAtivo(false);
        repository.save(usuarios);
        return "Usuário desativado com sucesso.";
    }
}
