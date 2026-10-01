package br.edu.ifrn.demodemo.service;

import br.edu.ifrn.demodemo.dto.VeiculoRequestDTO;
import br.edu.ifrn.demodemo.dto.VeiculoResponseDTO;
import br.edu.ifrn.demodemo.model.Veiculo;
import br.edu.ifrn.demodemo.repository.VeiculoRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;


    public List<VeiculoResponseDTO> listar() {
        return veiculoRepository.listar().stream()
                .map(VeiculoResponseDTO::fromModel)
                .toList();
    }

    public VeiculoResponseDTO listarPorId(Long id) {
       Veiculo veiculo = veiculoRepository.listarporid(id);

    }




    public VeiculoResponseDTO criarVeiculo(VeiculoRequestDTO veiculoRequestDTO) {
        Veiculo salvo = veiculoRepository.salvar(veiculoRequestDTO.toModel());
        return VeiculoResponseDTO.fromModel(salvo);
    }
}
