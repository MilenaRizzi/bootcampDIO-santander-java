package mockito.exemplos;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dio.mockito.exemplos.Email;
import com.dio.mockito.exemplos.Formato;
import com.dio.mockito.exemplos.PlataformaDeEnvio;
import com.dio.mockito.exemplos.ServicoEnvioEmail;

/**
 * Teste da classe {@link ServicoEnvioEmail} exemplificando testes usando Argument Captor
 */
@ExtendWith(MockitoExtension.class)
public class ServicoEnvioEmailTeste {

    @Mock
    private PlataformaDeEnvio plataforma;

    //a plataforma é uma dependencia da classe servico envio email, então precisamos injetar esse mock. a gente mocka a plataforma e injeta dentro da classe que queremos testar
    @InjectMocks
    private ServicoEnvioEmail servico;

    //ArgumentCaptor consegue capturar argumentos de um método
    @Captor
    private ArgumentCaptor<Email> emailCaptor;

    @Test
    public void validarDadosEnviadosParaAPlataforma() {
        
        String email = "usuario@teste.com";
        String mensagem = "Mensagem de Teste 123";
        boolean ehFormatoHTML = false;

        servico.enviaEmail(email, mensagem, ehFormatoHTML);

        //mockito verifica na plataforma qual foi o emial que foi enviado e captura para mim
        Mockito.verify(plataforma).enviaEmail(emailCaptor.capture());

        Email emailCapturado = emailCaptor.getValue();

        Assertions.assertEquals(email, emailCapturado.getEnderecoEmail());
        Assertions.assertEquals(mensagem, emailCapturado.getMensagem());
        Assertions.assertEquals(Formato.TEXTO, emailCapturado.getFormato());

    }
}
