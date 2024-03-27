package com.vgs.imobiliarium.service;

import com.vgs.imobiliarium.dto.CorretorDTO;
import com.vgs.imobiliarium.entity.Corretor;
import com.vgs.imobiliarium.repository.CorretorRepository;
import com.vgs.imobiliarium.viewdto.CorretorViewDTO;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CorretorService {

    @Autowired
    private CorretorRepository repository;

    private ModelMapper mapper = new ModelMapper();


    public List<CorretorViewDTO> getAll() {
        return repository.findAll().stream().map(
                corretor -> new CorretorViewDTO(
                        corretor.getId(), corretor.getCadastro(), corretor.getNumeroRegistro(),
                        corretor.getComissao(), corretor.getEspecialidade(), corretor.getCadastroAtivo(),
                        corretor.getUsuario()
                )
        ).collect(Collectors.toList());
    }

    public CorretorViewDTO getById(Long id) {
        Optional<Corretor> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Corretor não localizado.");
        }
        Corretor corretor = optional.get();
        return new CorretorViewDTO(
                corretor.getId(), corretor.getCadastro(), corretor.getNumeroRegistro(),
                corretor.getComissao(), corretor.getEspecialidade(), corretor.getCadastroAtivo(),
                corretor.getUsuario()
        );
    }

    @Transactional
    public CorretorViewDTO save(CorretorDTO corretor) {
        Corretor corrSave = mapper.map(corretor, Corretor.class);
        repository.save(corrSave);
        return new CorretorViewDTO(
                corretor.getId(), corretor.getCadastro(), corretor.getNumeroRegistro(),
                corretor.getComissao(), corretor.getEspecialidade(), corretor.getCadastroAtivo(),
                corretor.getUsuario()
        );
    }

    @Transactional
    public CorretorViewDTO update(CorretorDTO corretor) {
        Corretor corrSave = mapper.map(corretor, Corretor.class);
        Optional<Corretor> optional = repository.findById(corretor.getId());
        if (!optional.isPresent()) {
            throw new RuntimeException("Corretor não localizado.");
        }
        repository.save(corrSave);
        return new CorretorViewDTO(
                corretor.getId(), corretor.getCadastro(), corretor.getNumeroRegistro(),
                corretor.getComissao(), corretor.getEspecialidade(), corretor.getCadastroAtivo(),
                corretor.getUsuario()
        );
    }

    @Transactional
    public String delete(Long id) {
        Optional<Corretor> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Corretor não localizado.");
        }
        Corretor corretor = optional.get();
        corretor.setCadastroAtivo(false);
        repository.save(corretor);
        return "Corretor desativado com sucesso.";
    }
}
