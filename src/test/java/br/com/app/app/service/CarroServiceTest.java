package br.com.app.app.service;

import br.com.app.app.entity.Carro;
import br.com.app.app.entity.Marca;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CarroServiceTest {

    @Autowired
    CarroService carroService;

    @Test
    void cenario01(){

        org.junit.jupiter.api.Assertions.assertThrows(Exception.class, () -> {
            boolean retorno = carroService.verificarNomeCarro("Jeep Compass", 1959);
        });

//        org.junit.jupiter.api.Assertions.assertEquals(true, retorno);
    }

}
