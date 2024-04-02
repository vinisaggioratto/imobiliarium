package com.vgs.imobiliarium.service;

import com.vgs.imobiliarium.dto.InquilinoDTO;
import com.vgs.imobiliarium.entity.Inquilino;
import com.vgs.imobiliarium.repository.InquilinoRepository;
import com.vgs.imobiliarium.viewdto.InquilinoViewDTO;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InquilinoService {

    @Autowired
    private InquilinoRepository repository;

    private ModelMapper mapper = new ModelMapper();

    public List<InquilinoViewDTO> getAll() {
        return repository.findAll().stream().map(
                inquilino -> new InquilinoViewDTO(
                        inquilino.getId(), inquilino.getCadastro(), inquilino.getSalarioMensal(),
                        inquilino.getEmpresaTrabalho(), inquilino.getFuncao(), inquilino.getDataAdmissao(),
                        inquilino.getDependentes(), inquilino.getObservacoes(), inquilino.getCadastroAtivo(),
                        inquilino.getUsuario()
                )
        ).collect(Collectors.toList());
    }

    public InquilinoViewDTO getById(Long id) {
        Optional<Inquilino> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Inquilino não localizado.");
        }
        Inquilino inquilino = optional.get();
        return new InquilinoViewDTO(
                inquilino.getId(), inquilino.getCadastro(), inquilino.getSalarioMensal(),
                inquilino.getEmpresaTrabalho(), inquilino.getFuncao(), inquilino.getDataAdmissao(),
                inquilino.getDependentes(), inquilino.getObservacoes(), inquilino.getCadastroAtivo(),
                inquilino.getUsuario()
        );
    }

    @Transactional
    public InquilinoViewDTO save(InquilinoDTO inquilino) {
        inquilino.setDataCadastroInquilino(LocalDateTime.now());
        inquilino.setDataUpdateInquilino(LocalDateTime.now());
        Inquilino inqSave = mapper.map(inquilino, Inquilino.class);
        repository.save(inqSave);

        return new InquilinoViewDTO(
                inquilino.getId(), inquilino.getCadastro(), inquilino.getSalarioMensal(),
                inquilino.getEmpresaTrabalho(), inquilino.getFuncao(), inquilino.getDataAdmissao(),
                inquilino.getDependentes(), inquilino.getObservacoes(), inquilino.getCadastroAtivo(),
                inquilino.getUsuario()
        );
    }

    @Transactional
    public InquilinoViewDTO update(InquilinoDTO inquilino) {

        Optional<Inquilino> optional = repository.findById(inquilino.getId());
        if (!optional.isPresent()) {
            throw new RuntimeException("Inquilino não localizado.");
        }
        inquilino.setDataUpdateInquilino(LocalDateTime.now());
        Inquilino inqSave = mapper.map(inquilino, Inquilino.class);

        repository.save(inqSave);
        return new InquilinoViewDTO(
                inquilino.getId(), inquilino.getCadastro(), inquilino.getSalarioMensal(),
                inquilino.getEmpresaTrabalho(), inquilino.getFuncao(), inquilino.getDataAdmissao(),
                inquilino.getDependentes(), inquilino.getObservacoes(), inquilino.getCadastroAtivo(),
                inquilino.getUsuario()
        );
    }

    @Transactional
    public String delete(Long id) {
        Optional<Inquilino> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Inquilino não localizado.");
        }
        Inquilino inqSave = optional.get();
        inqSave.setDataUpdateInquilino(LocalDateTime.now());
        inqSave.setCadastroAtivo(false);
        repository.save(inqSave);
        return "Inquilino desativado com sucesso.";
    }
}
