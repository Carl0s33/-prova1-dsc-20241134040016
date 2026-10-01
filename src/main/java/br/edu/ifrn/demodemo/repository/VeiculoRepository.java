package br.edu.ifrn.demodemo.repository;

import br.edu.ifrn.demodemo.model.Veiculo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class VeiculoRepository {
    private final List<Veiculo> veiculos = new ArrayList<>();
    private final AtomicLong proximoId = new AtomicLong();

        public List<Veiculo> listar() {
        return veiculos;
    }

    public Veiculo listarporid(Long id){
        return veiculos.stream().filter(veiculo -> veiculo.getId().equals(id)).findFirst().orElse(null);
    }


    public Veiculo salvar(Veiculo veiculo) {
        if (veiculo.getId() == null) {
            veiculo.setId(proximoId.getAndIncrement());
            veiculos.add(veiculo);
            return veiculo;
        } else {
            deletarPorId(veiculo.getId());
            veiculos.add(veiculo);
        }
        return veiculo;
    }

    public void deletarPorId(Long id) {
        veiculos.removeIf(veiculo -> veiculo.getId().equals(id));
    }
}