package br.edu.ifrn.demodemo.repository;

import br.edu.ifrn.demodemo.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}
