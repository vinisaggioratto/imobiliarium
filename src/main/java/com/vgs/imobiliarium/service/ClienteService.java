package com.vgs.imobiliarium.service;

import com.vgs.imobiliarium.dto.ClienteDTO;
import com.vgs.imobiliarium.entity.Cliente;
import com.vgs.imobiliarium.repository.ClienteRepository;
import com.vgs.imobiliarium.viewdto.ClienteViewDTO;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    private ModelMapper mapper = new ModelMapper();

    public List<ClienteViewDTO> getAll() {
        return repository.findAll().stream().map(
                cliente -> new ClienteViewDTO(
                        cliente.getId(), cliente.getCadastro(), cliente.getPreferencias(), cliente.getObservacoes(),
                        cliente.getCadastroAtivo(), cliente.getUsuario()
                )
        ).collect(Collectors.toList());
    }

    public ClienteViewDTO getById(Long id) {
        Optional<Cliente> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Cliente não localizado.");
        }
        Cliente cliente = optional.get();
        return new ClienteViewDTO(
                cliente.getId(), cliente.getCadastro(), cliente.getPreferencias(), cliente.getObservacoes(),
                cliente.getCadastroAtivo(), cliente.getUsuario()
        );
    }

    @Transactional
    public ClienteViewDTO save(ClienteDTO cliente) {
        Cliente cliSave = mapper.map(cliente, Cliente.class);
        repository.save(cliSave);

        return new ClienteViewDTO(
                cliente.getId(), cliente.getCadastro(), cliente.getPreferencias(), cliente.getObservacoes(),
                cliente.getCadastroAtivo(), cliente.getUsuario()
        );
    }

    @Transactional
    public ClienteViewDTO update(ClienteDTO cliente) {
        Optional<Cliente> optional = repository.findById(cliente.getId());
        if (!optional.isPresent()) {
            throw new RuntimeException("Cliente não localizado.");
        }
        Cliente cliSave = mapper.map(cliente, Cliente.class);
        repository.save(cliSave);
        return new ClienteViewDTO(
                cliente.getId(), cliente.getCadastro(), cliente.getPreferencias(), cliente.getObservacoes(),
                cliente.getCadastroAtivo(), cliente.getUsuario()
        );
    }

    @Transactional
    public String delete(Long id) {
        Optional<Cliente> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Cliente não localizado.");
        }
        Cliente cliSave = optional.get();
        cliSave.setCadastroAtivo(false);
        repository.save(cliSave);
        return "Cliente desativado com sucesso.";
    }
}
