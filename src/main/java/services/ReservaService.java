package services;

import entities.ReservaEntity;
import repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public List<ReservaEntity> listarReservas() {
        return reservaRepository.findAll();
    }

    public Optional<ReservaEntity> obterReserva(Long id) {
        return reservaRepository.findById(id);
    }

    public ReservaEntity cadastrarReserva(ReservaEntity reserva) {
        return reservaRepository.save(reserva);
    }

    public void removerReserva(Long id) {
        reservaRepository.deleteById(id);
    }

    // Exemplo de método para obter todas as reservas de um cliente
    public List<ReservaEntity> listarReservasPorCliente(Long clienteId) {
        return reservaRepository.findByClienteId(clienteId);
    }

}