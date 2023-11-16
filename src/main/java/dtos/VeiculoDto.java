package dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeiculoDto {

    private String modelo;
    private String marca;
    private String cor;
    private Integer anoFabricacao;
    private Integer placa;

    public void setVeiculo(String modelo) {
    }
}
