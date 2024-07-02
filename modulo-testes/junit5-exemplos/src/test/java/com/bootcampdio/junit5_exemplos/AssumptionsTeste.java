package com.bootcampdio.junit5_exemplos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

public class AssumptionsTeste {

    @Test
    void validarAlgoSomenteNoUsuarioMilena() {
        // Assumptions.assumeFalse("root".equals(System.getenv("USERNAME"))); -> verifica se a variável de ambiente não é root

        //verifica se a minha variável de ambiente USERNAME é igual a Milenarizzi
        Assumptions.assumeTrue("Milenarizzi".equals(System.getenv("USERNAME")));
        Assertions.assertEquals(10, 5 + 5);
    }
}