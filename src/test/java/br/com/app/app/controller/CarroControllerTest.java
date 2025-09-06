package br.com.app.app.controller;

import br.com.app.app.entity.Carro;
import br.com.app.app.repository.CarroRepository;
import org.hibernate.dialect.pagination.OffsetFetchLimitHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.junit.jupiter.api.Assertions.*;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
public class CarroControllerTest{

    @Autowired
    CarroController controller;

    @MockitoBean
    CarroRepository carroRepository;

    @BeforeEach
    void setup(){
        List<Carro> carros = new ArrayList<>();
        carros.add(new Carro(1L, "Fiat", 2020, null, null));
        carros.add(new Carro(2L, "Ford", 2025, null, null));
        when(carroRepository.findAll()).thenReturn(carros);

        Carro carro = new Carro(1L, "Fiat", 2020, null, null);

        when(carroRepository.findById(1L)).thenReturn(Optional.of(carro));
    }

    @Test
    void cenario01(){
        ResponseEntity<List<Carro>> retorno = this.controller.findAll();
        org.junit.jupiter.api.Assertions.assertEquals(HttpStatus.OK, retorno.getStatusCode());
        Assertions.assertNotNull(retorno.getBody());
        org.junit.jupiter.api.Assertions.assertEquals(2, retorno.getBody().size());
    }

    /**
     * dados do mokito:
     * ID 1L
     * NAME "Fiat"
     * YEAR 2020
     * MARCA null
     * PROPRIETARIOS null
     */
    @Test
    void cenario02(){
        ResponseEntity<Carro> retorno = this.controller.findyById(1L);
        org.junit.jupiter.api.Assertions.assertEquals(1, retorno.getBody().getId());
    }
}
