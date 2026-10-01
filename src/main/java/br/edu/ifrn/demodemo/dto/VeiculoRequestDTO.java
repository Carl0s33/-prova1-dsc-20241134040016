package br.edu.ifrn.demodemo.dto;

import br.edu.ifrn.demodemo.model.Veiculo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@Builder 
@NoArgsConstructor 
@AllArgsConstructor 

public class VeiculoRequestDTO {

    @NotBlank(message = "A placa é unica entre os veiculos")
    private String placa;
    @NotBlank 
    private String modelo;

    @NotNull 
    private Integer anoFabricao;
    @NotBlank(message = "É obrigatorio possuir um tipo")
    private String tipo;

    @NotBlank
    private String nomeProprietario;

    public Veiculo toModel() {
        return new Veiculo(null, this.placa, this.modelo, this.tipo, this.anoFabricao, this.nomeProprietario);
    }
}


