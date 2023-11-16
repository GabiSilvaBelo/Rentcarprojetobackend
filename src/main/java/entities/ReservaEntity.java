package entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "reservas")
public class ReservaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "veiculo_id", nullable = false)
    private VeiculoEntity veiculo;

    @Column(nullable = false)
    private LocalDate dataInicio;

    @Column(nullable = false)
    private LocalDate dataFim;

    @Column(nullable = false)
    private Long clienteId;

    @PrePersist
    public void prePersist() {

        if (dataInicio.isAfter(dataFim)) {
            throw new RuntimeException("A data de início não pode ser posterior à data de término.");
        }
    }
}
