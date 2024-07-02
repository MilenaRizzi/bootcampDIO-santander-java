package com.bootcampdio.junit5_exemplos;

import org.junit.jupiter.api.*;

//A ideia é definir a ordem que os testes serão executados

/* MethodOrderer.OrderAnnotation.class 
 * quando uso order annotation eu preciso colocar a anotação
@Order para definir a ordem dos testes */ 

/* MethodOrderer.MethodName.class 
 * vai levar em consideração o nome do método  
 * vai olhar os nomes dos métodos e vai executar de acordo com
a ordem alfabética */

/* MethodOrderer.Random.class
 * executa aleatoriamente */

/* MethodOrderer.DisplayName.class
 * recurso para nomear o nosso teste. Então é ordenado com base
no que está escrito em display name 
 * muito usado para fazer uma melhoria na escrita, em saber 
o que o método vai fazer */
   
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class EscolhendoAOrdemTeste {

    //Order(4)
    @DisplayName("Teste que valida se o usuário foi criado")
    @Test
    void validaFluxoA() {
        Assertions.assertTrue(true);
    }

    //Order(3)
    @DisplayName("B")
    @Test
    void validaFluxoB() {
        Assertions.assertTrue(true);
    }

    //Order(2)
    @DisplayName("C")
    @Test
    void validaFluxoC() {
        Assertions.assertTrue(true);
    }

    //Order(1)
    @DisplayName("D")
    @Test
    void validaFluxoD() {
        Assertions.assertTrue(true);
    }
}
