package br.edu.ifrn.demodemo.controller;

import br.edu.ifrn.demodemo.dto.VeiculoRequestDTO;
import br.edu.ifrn.demodemo.dto.VeiculoResponseDTO;
import br.edu.ifrn.demodemo.service.VeiculoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/veiculos")
@RequiredArgsConstructor

public class VeiculoController {

    private final VeiculoService veiculoService;


    @PostMapping
    public ResponseEntity<VeiculoResponseDTO> criar(@Valid @RequestBody VeiculoRequestDTO requestDTO) {
        VeiculoResponseDTO veiculoResponseDTO = veiculoService.criarVeiculo(requestDTO);
        URI location = URI.create("/veiculos/" + veiculoResponseDTO.getId());
        return ResponseEntity.created(location).body(veiculoResponseDTO);
    }

    @GetMapping
    public List<VeiculoResponseDTO> listar() {
        return veiculoService.listar();
    }



    @GetMapping("/{id}")
    public VeiculoResponseDTO listarPorId(@PathVariable Long id) {
        return veiculoService.listar(id);
    }

}
