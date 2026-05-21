package com.Beetles.systempayout.backend.aluno.service;

import com.Beetles.systempayout.backend.aluno.controller.request.AlunoRequest;
import com.Beetles.systempayout.backend.aluno.model.Aluno;
import com.Beetles.systempayout.backend.aluno.repository.AlunoRepository;
import com.Beetles.systempayout.backend.shared.exception.IdNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class AlunoService{

    private final AlunoRepository repository;
    private final PasswordEncoder passwordEncoder;

    public AlunoService(AlunoRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional(readOnly = true)
    public Page<Aluno> listUsers(Pageable pageable) {
        return repository.findAll(pageable);
    }


    @Transactional(readOnly = true)
    public Aluno listUserById(UUID id) {
        return repository.findById(id)
                .orElseThrow(()-> new IdNotFoundException(id));
    }

    @Transactional
    public Aluno registerUser(AlunoRequest request) {
        Aluno aluno = new Aluno();

        aluno.setNome(request.nome());
        aluno.setPlanoEscolhidoId(request.plano());
        aluno.setStatus(request.status());

        return repository.save(aluno);
    }


    @Transactional
    public void deleteUserById(UUID id) {
        if (!repository.existsById(id)) {
            throw new IdNotFoundException(id);
        }
        repository.deleteById(id);
    }

    @Transactional
    public Aluno updateUser(UUID id, AlunoRequest request) {
        Aluno aluno = repository.findById(id)
            .orElseThrow(() -> new IdNotFoundException(id));

        if (request.nome() != null) {
            aluno.setNome(request.nome());
        }
        if (request.status() != null){
            aluno.setStatus(request.status());
        }
        if (request.plano() != null) {
            aluno.setPlanoEscolhidoId(request.plano());
        }
        return repository.save(aluno);

    }
}