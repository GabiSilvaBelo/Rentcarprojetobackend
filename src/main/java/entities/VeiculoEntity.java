package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "veiculo")
public class VeiculoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idveiculo")
    private Integer id;

    @Column(name = "modeloveiculo")
    private String modelo;

    @Column(name = "marcaveiculo")
    private String marca;

    @Column(name = "cor")
    private String cor;

    @Column(name = "anofabricacao")
    private Integer anofabricacao;

    @Column(name = "placa")
    private Integer placa;

}
