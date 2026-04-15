package com.Beetles.systempayout.backend.plano.controller;

import com.Beetles.systempayout.backend.plano.DTO.PlanoDTO;
import com.Beetles.systempayout.backend.plano.service.PlanosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/plano")
public class PlanoController {

    private final PlanosService service;

    public PlanoController(PlanosService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PlanoDTO> salvarPlano(@RequestBody PlanoDTO planoDTO) {
        PlanoDTO planoSalvo = service.criarPlano(planoDTO);
        return new ResponseEntity<>(planoSalvo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PlanoDTO>> mostrarPlanos() {
        List<PlanoDTO> lista = service.mostrarTodosPlanos();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanoDTO> verPlanoEspecifico(@PathVariable UUID id) {
        PlanoDTO planoDTO = service.mostrarPlanoEspecificoPeloId(id);
        return new ResponseEntity<>(planoDTO, HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanoDTO> atualizarPlano(@RequestBody PlanoDTO planoDTO, @PathVariable UUID id) {
        PlanoDTO planoAtt = service.modificarPlano(planoDTO, id);
        return new ResponseEntity<>(planoAtt, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void apagarPlano(@PathVariable UUID id){
        service.deletarPlano(id);
        new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}