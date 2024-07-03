package mockito.exemplos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dio.mockito.exemplos.Conta;

/**
 * Teste da classe {@link Conta} usando Spy para realizar o recurso de
 * verificações
 */
@ExtendWith(MockitoExtension.class)
public class ContaTeste {

    // estou espiando o objeto conta
    // spy é uma forma de testar mais ligada ao comportamento, passa a ter um objeto um pouco mais real
    // e tudo que for chamado, os metodos e tal, eles realmente serão executados e assim se consegue observar o comportamento de certa classe de maneira mais detalhada

    // Já o mocki é voltado mais para colocar uma dependencia que faz parte do fluxo de teste mas que não se quer testar necessariamente
    @Spy
    private Conta conta = new Conta(3000);

    @Test
    void verificaSeChamouMetodoDebita() {
        conta.pagaBoleto(300);
        Mockito.verify(conta).debita(300);
    }

    @Test
    void verificaSeNadaFoiChamado() {
        Mockito.verifyNoInteractions(conta);
    }

    // quero observar a ordem em que vai acontecer algumas coisas nessa referencia
    // então eu verifico se o objeto que eu estou espiando, que é classe, ele está
    // seguindo a ordem da qual é esperada.
    @Test
    void verificaAOrdemDasChamadas() {
        // InOrder inOrder = Mockito.inOrder(conta);
        // conta.pagaBoleto(300);
        // conta.debita(300);
        // conta.enviaCreditoParaEmissor(300);
        // inOrder.verify(conta).pagaBoleto(300);
        // inOrder.verify(conta).debita(300);
        // inOrder.verify(conta).enviaCreditoParaEmissor(300);

        conta.pagaBoleto(300);

        InOrder inOrder = Mockito.inOrder(conta);
        inOrder.verify(conta).pagaBoleto(300);
        inOrder.verify(conta).validaSaldo(300);
        inOrder.verify(conta).debita(300);
        inOrder.verify(conta).enviaCreditoParaEmissor(300);

        //poderia colocar - para verificar qualquer inteiro e não o valor específico
        //inOrder.verify(conta).pagaBoleto(ArgumentMatchers.anyInt());
    }

    @Test
    void validaQuantidadeDeVezesQueMétodoFoiChamado() {

        conta.validaSaldo(300);
        conta.validaSaldo(500);
        conta.validaSaldo(600);

        //mockito verifica para mim no objeto conta, se foi chamado 3 vezes o valida saldo
        //ajuda a observar o que aconteceu
        Mockito.verify(conta, Mockito.times(3)).validaSaldo(ArgumentMatchers.anyInt());
    }
}
