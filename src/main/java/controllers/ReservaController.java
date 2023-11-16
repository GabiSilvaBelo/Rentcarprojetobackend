package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("reservas")
public class ReservaController {

    @GetMapping
    public String statusGet(){
        return "Server is on line!";
    }

    @PostMapping
    public String criarReserva(@RequestBody String nome){
        return nome;
    }

}
