package br.com.app.app.service;

import br.com.app.app.entity.Carro;
import br.com.app.app.entity.Marca;
import br.com.app.app.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public String save(@RequestBody Carro carro){

        this.verificarNomeCarro(carro.getName(), carro.getYear());

        this.carroRepository.save(carro);
        return "Carro salvo com sucesso";
    }

    //regra de negócio do app
    public boolean verificarNomeCarro(String name, int year){
        if (name.equals("Jeep Compass") && year < 1960){
            throw new RuntimeException();
        }
        return true;
    }

    public String update(@RequestBody Carro carro, Long id){
        carro.setId(id);
        this.carroRepository.save(carro);
        return "carro atualizado com sucesso!";
    }

    public String delete(Long id){
        this.carroRepository.deleteById(id);
        return "Carro deletado com sucesso!";
    }

    public List<Carro> findAll(){
        return  this.carroRepository.findAll();
    }

    public Carro findyById(Long id){
        return this.carroRepository.findById(id).get();
    }


    public List<Carro> findByName(String name){
        return this.carroRepository.findByName(name);
    }

    public List<Carro> findByMarca(Long idMarca){
        Marca marca = new Marca();
        marca.setId(idMarca);
        return this.carroRepository.findByMarca(marca);
    }

    public List<Carro> findAcimaAno(int year){
        return this.carroRepository.findAcimaAno(year);
    }
}
