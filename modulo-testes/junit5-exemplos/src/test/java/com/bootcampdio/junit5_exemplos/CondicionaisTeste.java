package com.bootcampdio.junit5_exemplos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

public class CondicionaisTeste {
    
    @Test
    //Se a variável de ambiente username for milenarizzi então eu habilito o teste
    @EnabledIfEnvironmentVariable(named = "USERNAME", matches = "Milenarizzi")
    //-> se o usuário for root eu desabilito esse teste
    // @DisableIfEnvironmentVariable(named = "USERNAME", matches = "root") 

    //-> validar o teste apenas se estiver em ambiente linux
    //@EnableOnOs(OS.LINUX)

    //-> para executar em uma determinada JRE
    //@EnabledOnJre(JAVA_17)
    
    //-> para determinar o mínimo ou o máximo. Para executar esse programa eu quero pelo menos o java 11 e no maximo o java 17
    //@EnableForJreRange(min = JAVA_11, max = JAVA_17)
    void validarAlgoSomenteNoUsuarioMilena() {
        Assertions.assertEquals(10, 5 + 5);
    }
}
