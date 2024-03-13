package com.vgs.imobiliarium.service;

import com.vgs.imobiliarium.dto.ComissaoDTO;
import com.vgs.imobiliarium.entity.Comissao;
import com.vgs.imobiliarium.enums.TipoComissao;
import com.vgs.imobiliarium.repository.ComissaoRepository;
import com.vgs.imobiliarium.viewdto.ComissaoViewDTO;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ComissaoService {

    @Autowired
    private ComissaoRepository repository;

    private ModelMapper mapper = new ModelMapper();

    public List<ComissaoViewDTO> getAll() {
        return repository.findAll().stream().map(
                comissao -> new ComissaoViewDTO(
                    comissao.getId(), comissao.getPercentual(), comissao.getTipoComissao(),
                        comissao.getCadastroAtivo(), comissao.getUsuarios()
                )
        ).collect(Collectors.toList());
    }

    public ComissaoViewDTO getById(Long id) {
        Optional<Comissao> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Cadastro da comissão não localizado.");
        }
        Comissao comissao = optional.get();
        return new ComissaoViewDTO(
                comissao.getId(), comissao.getPercentual(), comissao.getTipoComissao(),
                comissao.getCadastroAtivo(), comissao.getUsuarios());
    }

    @Transactional
    public ComissaoViewDTO save(ComissaoDTO comissao) {
        Comissao comSave = mapper.map(comissao, Comissao.class);
        repository.save(comSave);
        return new ComissaoViewDTO(
                comissao.getId(), comissao.getPercentual(), comissao.getTipoComissao(),
                comissao.getCadastroAtivo(), comissao.getUsuarios());
    }

    @Transactional
    public ComissaoViewDTO update(ComissaoDTO comissao){
        Comissao comSave = mapper.map(comissao, Comissao.class);
        Optional<Comissao> optional = repository.findById(comissao.getId());
        if (!optional.isPresent()){
            throw new RuntimeException("Cadastro da comissão não localizado.");
        }
        repository.save(comSave);
        return new ComissaoViewDTO(
                comissao.getId(), comissao.getPercentual(), comissao.getTipoComissao(),
                comissao.getCadastroAtivo(), comissao.getUsuarios());
    }

    @Transactional
    public String delete(Long id){
        Optional<Comissao> optional = repository.findById(id);
        if (!optional.isPresent()){
            throw new RuntimeException("Cadastro da comissão não localizado.");
        }
        Comissao comSave = optional.get();
        comSave.setCadastroAtivo(false);
        repository.save(comSave);
        return "Cadastro da comissão desativado com sucesso.";
    }
}
