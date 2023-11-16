package controllers;

import dtos.VeiculoDto;
import services.VeiculoService;
import entities.VeiculoEntity;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("veiculos")
public class VeiculoController {

    @Autowired
    VeiculoService veiculoService;

    @PostMapping("/inserir")
    public String criarVeiculo(@RequestBody VeiculoEntity veiculo){
        if(veiculo.getId() == null) {
            veiculoService.inserirAlterarVeiculo(veiculo);
            return "Veiculo inserido com sucesso!";
        } else {
            return "Veiculo não inserido!";
        }
    }

    @GetMapping("/listar")
    public List<VeiculoDto> listarVeiculos(@PathParam("modelo") String modelo){
        List<VeiculoDto> veiculo = veiculoService.buscarTodosOsVeiculos(modelo);
        return veiculo;
    }

    @PutMapping("/alterar")
    public ResponseEntity alterarVeiculo(@RequestBody VeiculoEntity veiculo){
        if(veiculo.getId() != null) {
            veiculoService.inserirAlterarVeiculo(veiculo);
            return ResponseEntity.status(200).body(veiculo);
        } else {
            return ResponseEntity.status(500).body("Erro ao alterar Veiculo");
        }
    }

    @DeleteMapping("/deletar")
    public void apagaVeiculo(@PathParam("id") Integer id, @PathParam("placa") String placa){
        veiculoService.apagarVeiculo(id, placa);
    }

}
