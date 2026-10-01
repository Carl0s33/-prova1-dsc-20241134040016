package br.edu.ifrn.demodemo.dto;

import br.edu.ifrn.demodemo.model.Veiculo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@Builder 
@NoArgsConstructor 
@AllArgsConstructor 
public class VeiculoResponseDTO {
 
 
    private Long id;
    private String placa;
    private String modelo;
    private Integer anoFabricao;
    private String tipo;
    private String nomeProprietario;


    public VeiculoResponseDTO(Veiculo veiculo){
        this(
            veiculo.getId(),
            veiculo.getModelo(),
            veiculo.getPlaca(),
            veiculo.getAnoFabricao(),
            veiculo.getTipo(),
            veiculo.getNomeProprietario()
        );
    
    }

    public static VeiculoResponseDTO fromModel (Veiculo veiculo){
        return VeiculoResponseDTO.builder()
                .id(veiculo.getId())
                .placa(veiculo.getPlaca())
                .modelo(veiculo.getModelo())
                .placa(veiculo.getPlaca())
                .tipo(veiculo.getTipo())
                .nomeProprietario(veiculo.getNomeProprietario())
                .build();

    }

}
