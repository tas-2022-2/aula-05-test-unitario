package com.example.demo.negocio;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// SUT: System Under Test (protagonista do teste? Comprimento)
// class RastreamentoService { // stubs, mocks, fakes, ...
//     RastreamentoService(CorreioService correio, MapsService mapsService) {

//     }
// }

class ComprimentoTest {

    String a;

    // assertTrue, assertFalse
    // assertEquals, assertNotEquals
    // assertNull, assertNotNull
    // 

    @Test
    @DisplayName("Nova instância deve ter comprimento 0mm")
    void testNovaInstanciaSemArgumentosDeveConsiderarZeroMm() {
        Comprimento zero1 = new Comprimento();

        Assertions.assertTrue(zero1 != null);
        Assertions.assertNotNull(zero1);

        Assertions.assertEquals(0, zero1.milimetros, "Comprimento é zero");
        //System.out.println(zero1.milimetros == 0);

    }

    @Test
    void testComprimentoNaoZeroDeveMostrarValorCorretoMilimetros() {
        Comprimento umMetroMeio = new Comprimento(1.5);

        Assertions.assertEquals(1500, umMetroMeio.milimetros);
        //System.out.println(umMetroMeio.milimetros == 1500);
    }

    @Test
    void testComprimentoZeroDeveLancarIllegalArgumentException() {
        
        try {
            Comprimento invalido1 = new Comprimento(-1.0);
            Assertions.fail("Não lançou a exceção");
        } catch (IllegalArgumentException e) {
           // 🙌 
           Assertions.assertEquals("Milimetro deve ser positivo", e.getMessage());
        }
    }

    @Test
    void testComprimentoZeroDeveLancarIllegalArgumentException2() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Comprimento invalido1 = new Comprimento(-1.0);
        });

        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            Comprimento invalido1 = new Comprimento(-0.01);
        }, () -> {
            return "Milimetro deve ser positivo";
        });
    }

    @Test
    void testCincoPolegadasDeveDevolverPontoCentoVinteSeteMetros() {
        Comprimento c = Comprimento.fromPolegadas(5.0);

        Assertions.assertEquals(0.127, 
            c.getMetros(), 
            0.000001);

        
        BigDecimal pontoum = new BigDecimal("0.1");
        BigDecimal add = pontoum.add(pontoum).add(pontoum);

        System.out.println(add);
        // 10 / 3 = 0.33333333
        // 0.99999999999
        Assertions.assertEquals(new BigDecimal("0.3"),
                add);
    }


}
