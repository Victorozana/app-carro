package br.com.app.app.repository;


import br.com.app.app.entity.Carro;
import br.com.app.app.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, Long > {

    public List<Carro> findByName(String name);
    public List<Carro> findByMarca(Marca marca);

    @Query("FROM Carro c WHERE c.year > :year")
    public List<Carro> findAcimaAno(int year);
}
