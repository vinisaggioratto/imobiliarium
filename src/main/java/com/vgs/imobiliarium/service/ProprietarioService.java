package com.vgs.imobiliarium.service;

import com.vgs.imobiliarium.dto.ProprietarioDTO;
import com.vgs.imobiliarium.entity.Proprietario;
import com.vgs.imobiliarium.repository.ProprietarioRepository;
import com.vgs.imobiliarium.viewdto.ProprietarioViewDTO;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProprietarioService {

    @Autowired
    private ProprietarioRepository repository;

    private ModelMapper mapper = new ModelMapper();

    public List<ProprietarioViewDTO> getAll() {
        return repository.findAll().stream().map(
                proprietario -> new ProprietarioViewDTO(
                        proprietario.getId(), proprietario.getCadastro(), proprietario.getCadastroAtivo(),
                        proprietario.getUsuario()
                )
        ).collect(Collectors.toList());
    }

    public ProprietarioViewDTO getById(Long id) {
        Optional<Proprietario> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Proprietário não localizado.");
        }
        Proprietario proprietario = optional.get();
        return new ProprietarioViewDTO(
                proprietario.getId(), proprietario.getCadastro(), proprietario.getCadastroAtivo(),
                proprietario.getUsuario()
        );
    }

    @Transactional
    public ProprietarioViewDTO save(ProprietarioDTO proprietario) {
        Proprietario proSave = mapper.map(proprietario, Proprietario.class);

        repository.save(proSave);
        return new ProprietarioViewDTO(
                proprietario.getId(), proprietario.getCadastro(), proprietario.getCadastroAtivo(),
                proprietario.getUsuario()
        );
    }

    @Transactional
    public ProprietarioViewDTO update(ProprietarioDTO proprietario) {
        Optional<Proprietario> optional = repository.findById(proprietario.getId());
        if (!optional.isPresent()) {
            throw new RuntimeException("Proprietário não localizado.");
        }
        Proprietario proSave = mapper.map(proprietario, Proprietario.class);
        repository.save(proSave);
        return new ProprietarioViewDTO(
                proprietario.getId(), proprietario.getCadastro(), proprietario.getCadastroAtivo(),
                proprietario.getUsuario()
        );
    }

    @Transactional
    public String delete(Long id){
        Optional<Proprietario> optional = repository.findById(id);
        if (!optional.isPresent()){
            throw new RuntimeException("Proprietário não localizado.");
        }
        Proprietario proprietario = optional.get();
        proprietario.setCadastroAtivo(false);
        repository.save(proprietario);
        return "Proprietário desativado com sucesso.";
    }
}
