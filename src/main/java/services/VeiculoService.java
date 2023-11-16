package services;

import dtos.VeiculoDto;
import entities.VeiculoEntity;
import repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<VeiculoDto> buscarTodosOsVeiculos(String reserva){
        List<VeiculoEntity> veiculoEntityList = new ArrayList<>();

        if(reserva == null) {
            veiculoEntityList = veiculoRepository.findAll();
        } else {
            veiculoEntityList = veiculoRepository.findAllByReserva(reserva);
        }

        List<VeiculoDto> veiculoDtoList = new ArrayList<>();
        for (VeiculoEntity veiculoEntity:veiculoEntityList) {
            VeiculoDto veiculoDto = new VeiculoDto();
            veiculoDto.setVeiculo(veiculoEntity.getModelo());
            veiculoDto.setVeiculo(veiculoEntity.getModelo());

            veiculoDtoList.add(veiculoDto);
        }

        return veiculoDtoList;
    }

    public void inserirAlterarVeiculo(VeiculoEntity veiculo){
        veiculoRepository.save(veiculo);
    }

    public void apagarVeiculo(Integer id, String veiculo){
        List<VeiculoEntity> veiculoEntity = veiculoRepository.findAllByIdAndVeiculo(id, veiculo);
        veiculoRepository.deleteAll(veiculoEntity);
    }

    public void inserirAlterarLargaEscala(List<VeiculoEntity> veiculo){
        veiculoRepository.saveAll(veiculo);
    }
}
