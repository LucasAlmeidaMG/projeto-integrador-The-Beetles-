package com.Beetles.systempayout.backend.plano.service;

import com.Beetles.systempayout.backend.aluno.Mapper.AlunoMapper;
import com.Beetles.systempayout.backend.plano.DTO.PlanoDTO;
import com.Beetles.systempayout.backend.plano.mapper.PlanoMapper;
import com.Beetles.systempayout.backend.plano.model.Plano;
import com.Beetles.systempayout.backend.plano.repository.PlanoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.Beetles.systempayout.backend.shared.utils.DateTimeLocal.pegarHorarioAtual;

@Service
public class PlanosService {
    private final PlanoRepository repository;
    private final PlanoMapper planoMapper;
    private final AlunoMapper alunoMapper;

    public PlanosService(PlanoRepository repository, PlanoMapper planoMapper, AlunoMapper alunoMapper) {
        this.repository = repository;
        this.planoMapper = planoMapper;
        this.alunoMapper = alunoMapper;
    }

    @Transactional
    public PlanoDTO criarPlano(PlanoDTO planoDTO){
        Plano plano = planoMapper.map(planoDTO);
        plano.setDataCriacao(pegarHorarioAtual());
        plano = repository.save(plano);
        return planoMapper.map(plano);
    }

    public List<PlanoDTO> mostrarTodosPlanos(){
        List<Plano> plano = repository.findAll();
        return plano.stream()
                .map(planoMapper::map)
                .collect(Collectors.toList());
    }
    public PlanoDTO mostrarPlanoEspecificoPeloId(UUID id){
        Optional<Plano> plano = repository.findById(id);
        return plano.map(planoMapper::map).orElse(null);
    }
    @Transactional
    public PlanoDTO modificarPlano(PlanoDTO planoDTO, UUID id){
        Plano plano = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Id não encontrado"));
        if (planoDTO.getNome() != null){
            plano.setNome(planoDTO.getNome());
        }
        if (planoDTO.getCategoria() != null){
            plano.setCategoria(planoDTO.getCategoria());
        }
        if (planoDTO.getValor() != null){
            plano.setValor(planoDTO.getValor());
        }
        if (planoDTO.getAlunos() != null){
            plano.setAlunos(planoDTO.getAlunos());
        }
        if (planoDTO.getFrequenciaAulas() != null){
            plano.setFrequenciaAulas(planoDTO.getFrequenciaAulas());
        }
        repository.save(plano);
        return planoMapper.map(plano);
    }

    @Transactional
    public void deletarPlano(UUID id){
        if(!repository.existsById(id)) {
            repository.deleteById(id);
        }
        if(repository.findById(id) == null){
            throw new RuntimeException("O Id não pode ser null");
        }
        throw new RuntimeException("Id não encontrado");
    }
}