package br.edu.ifrn.demodemo.service;


import br.edu.ifrn.demodemo.dto.VeiculoRequestDTO;
import br.edu.ifrn.demodemo.dto.VeiculoResponseDTO;
import br.edu.ifrn.demodemo.model.Veiculo;
import br.edu.ifrn.demodemo.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;


        public List<VeiculoResponseDTO> listar(){
            return veiculoRepository.findAll().stream()
                    .map(VeiculoResponseDTO::fromModel)
                    .toList();
        }

        public VeiculoResponseDTO criar(VeiculoRequestDTO dto){
            Veiculo salvo = veiculoRepository.save(dto.toModel());
            return VeiculoResponseDTO.fromModel(salvo);
        }
        public VeiculoResponseDTO buscar(Long id){
           Veiculo veiculo = veiculoRepository.findById(id).orElseThrow();
           return VeiculoResponseDTO.fromModel(veiculo);

        }
        public void deletar(Long id){
            veiculoRepository.deleteById(id);
        }
}
