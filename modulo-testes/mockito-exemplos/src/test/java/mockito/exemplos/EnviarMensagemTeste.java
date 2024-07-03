package mockito.exemplos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dio.mockito.exemplos.EnviarMensagem;
import com.dio.mockito.exemplos.Mensagem;

import static org.mockito.Mockito.verify;

/**
 * Teste da classe {@link EnviarMensagem} exemplificando Spy
 */
@ExtendWith(MockitoExtension.class)
public class EnviarMensagemTeste {

    //o spy referencia o objeto real da classe e isso ajuda muito a ter um contato mais proximo com o comportamento da classe. O que está acontecendo por baixo dos panos na classe.
    @Spy
    EnviarMensagem enviarMensagem = new EnviarMensagem();

    @Test
    void adicionarMensagem() {
        //verifica se inicialmente não há nenhuma interação
        Mockito.verifyNoInteractions(enviarMensagem);

        Mensagem mensagem = new Mensagem("Hello World");

        enviarMensagem.adicionarMensagem(mensagem);

        //verifica se o enviar mensagem chamou o adicionar mensagem com o objeto passado por parâmetro
        verify(enviarMensagem).adicionarMensagem(mensagem);

        //como adicionamos uma mensagem a lista de mensagens, então aqui vamos verificar se realmente foi adicionado e se a lista não está vazia
        //então aqui eu verifico se o tamanho da minha lista é 1
        Assertions.assertEquals(1, enviarMensagem.getMensagens().size());
    
        //aqui eu verifico se a lista realmente não está vazia
        //Assertions.assertFalse(enviarMensagem.getMensagens().isEmpty())
    }


}
