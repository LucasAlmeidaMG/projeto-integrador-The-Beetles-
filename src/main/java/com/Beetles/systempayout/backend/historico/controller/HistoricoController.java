package com.Beetles.systempayout.backend.historico.controller;

import com.Beetles.systempayout.backend.historico.controller.Mapper.HistoricoMapper;
import com.Beetles.systempayout.backend.historico.controller.Request.HistoricoRequest;
import com.Beetles.systempayout.backend.historico.controller.Response.HistoricoResponse;
import com.Beetles.systempayout.backend.historico.model.Historico;
import com.Beetles.systempayout.backend.historico.service.HistoricoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/historico")
public class HistoricoController {
    private final HistoricoService service;

    public HistoricoController(HistoricoService service) {
        this.service = service;
    }

    @PostMapping("/salvar")
    public ResponseEntity<HistoricoResponse> salvar(@RequestBody HistoricoRequest historico){
        Historico historicoCriado = service.salvarHistorico(HistoricoMapper.mapRequest(historico));
        HistoricoResponse historicoResponse = HistoricoMapper.mapResponse(historicoCriado);
        return new ResponseEntity<>(historicoResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoricoResponse> buscar(@PathVariable UUID id){
        Historico historico = service.verHistoricoId(id);
        return new ResponseEntity<>(HistoricoMapper.mapResponse(historico), HttpStatus.FOUND);
    }

    @PostMapping("/solicitacao/{id}")
    public ResponseEntity<HistoricoResponse> solicitar(@PathVariable UUID id){
        Historico historicoSolicitacao = service.registrarDataDeSolicitacao(id);
        return new ResponseEntity<>(HistoricoMapper.mapResponse(historicoSolicitacao), HttpStatus.ACCEPTED);
    }

    @PostMapping("/confirmar/{id}")
    public ResponseEntity<HistoricoResponse> confirmar(@PathVariable UUID id){
        Historico historico = service.registrarDataDeConfirmacao(id);
        return new ResponseEntity<>(HistoricoMapper.mapResponse(historico), HttpStatus.ACCEPTED);
    }
}
