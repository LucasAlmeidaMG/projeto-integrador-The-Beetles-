package com.Beetles.systempayout.backend.aluno.Mapper;

import com.Beetles.systempayout.backend.aluno.DTO.AlunoDTO;
import com.Beetles.systempayout.backend.aluno.model.Aluno;
import org.springframework.stereotype.Component;

@Component
public class AlunoMapper {

    public Aluno map(AlunoDTO alunoDTO){
        Aluno aluno = new Aluno();

        aluno.setNome(alunoDTO.getNome());
        aluno.setStatus(alunoDTO.getStatus());
        aluno.setTelefone(alunoDTO.getTelefone());
        aluno.setPrimeiroAcesso(alunoDTO.isPrimeiroAcesso());
        aluno.setPlanoEscolhidoId(alunoDTO.getPlanoEscolhidoId());
        aluno.setDiaVencimento(alunoDTO.getDiaVencimento());
        aluno.setDataProximoVencimento(alunoDTO.getDataProximoVencimento());
        aluno.setDataInicioPlano(alunoDTO.getDataInicioPlano());
        return aluno;
    }

    public AlunoDTO map(Aluno aluno){
        AlunoDTO alunoDTO = new AlunoDTO();

        alunoDTO.setPrimeiroAcesso(aluno.isPrimeiroAcesso());
        alunoDTO.setNome(aluno.getNome());
        alunoDTO.setStatus(aluno.getStatus());
        alunoDTO.setTelefone(aluno.getTelefone());
        alunoDTO.setPlanoEscolhidoId(aluno.getPlanoEscolhidoId());
        alunoDTO.setDataCadastro(aluno.getDataCadastro());
        alunoDTO.setDiaVencimento(aluno.getDiaVencimento());
        alunoDTO.setDataProximoVencimento(aluno.getDataProximoVencimento());
        alunoDTO.setDataInicioPlano(aluno.getDataInicioPlano());

        return alunoDTO;
    }
}
