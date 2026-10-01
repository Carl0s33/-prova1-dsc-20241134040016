package br.edu.ifrn.demodemo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "veiculos")
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placa;
    private String modelo;
    private Integer anoFabricao;
    private String tipo;
    private String nomeProprietario;


    public Veiculo(Long id, @NotBlank(message = "A placa é unica entre os veiculos") String placa, @NotBlank String modelo, @NotBlank(message = "É obrigatorio possuir um titulo") String tipo, @NotNull Integer anoFabricao, @NotBlank String nomeProprietario) {
    }
}
