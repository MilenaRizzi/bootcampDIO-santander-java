package com.bootcampdio.junit5_exemplos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExceptionsTeste {

    @Test
    void validarCenarioDeExcecaoNaTransferencia() {
        Conta contaOrigem = new Conta("123456", 0);
        Conta contaDestino = new Conta("456548", 100);

        TransferenciaEntreContas transferenciaEntreContas = new TransferenciaEntreContas();


        //transferi de uma conta para outra o valor de -1 e método de teste passou, ou seja, de fato caiu na exceção que está na classe transferencia entre contas
        //assertThrows espera que uma exceção seja lançada
        // Assertions.assertThrows(IllegalArgumentException.class, () -> transferenciaEntreContas.transfere(contaOrigem, contaDestino, -1));

        //Verifica se algo não vai lançar exceção -> então nesse caso eu passo eu valor 20 e o método é aceito, pois o valor 20 é correto e não dispara exceção. 
        Assertions.assertDoesNotThrow(() -> transferenciaEntreContas.transfere(contaOrigem, contaDestino, 20));
    }
}
