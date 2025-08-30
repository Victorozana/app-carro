package br.com.app.app.controller;

import br.com.app.app.entity.Carro;
import br.com.app.app.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carro")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Carro carro){
        try {
            String message = this.carroService.save(carro);
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody Carro carro, @RequestParam Long id){
        try {
           String message = this.carroService.update(carro, id);
           return new ResponseEntity<>(message, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@PathVariable Long id){
        try {
            String message = this.carroService.delete(id);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<List<Carro>> findAll(){
        try {
            List<Carro> list = this.carroService.findAll();
            return new ResponseEntity<>(list, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getId/{id}")
    public ResponseEntity<Carro> findyById(@PathVariable Long id){
        try {
            Carro carro = this.carroService.findyById(id);
            return new ResponseEntity<>(carro, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
