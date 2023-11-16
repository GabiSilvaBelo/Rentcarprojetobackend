package repositories;

import entities.VeiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<VeiculoEntity, Integer> {
    List<VeiculoEntity> findAllByReserva(String reserva);
    List<VeiculoEntity> findAllByIdAndVeiculo(Integer id, String veiculo);
}
