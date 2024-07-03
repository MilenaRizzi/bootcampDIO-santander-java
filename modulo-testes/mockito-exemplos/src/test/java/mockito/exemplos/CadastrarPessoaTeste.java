package mockito.exemplos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dio.mockito.exemplos.ApiDosCorreios;
import com.dio.mockito.exemplos.CadastrarPessoa;
import com.dio.mockito.exemplos.DadosLocalizacao;
import com.dio.mockito.exemplos.Pessoa;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.anyString;

/**
 * Teste da classe {@link CadastrarPessoa} apresentando cenários básicos de uso do Mockito, usando o recurso
 * de mocks e a manipulação de retornos, da forma mais simples e com manipulação de erros
 */
@ExtendWith(MockitoExtension.class) //para que seja possível usar o mockito
public class CadastrarPessoaTeste {

    @Mock
    private ApiDosCorreios apiDosCorreios;

    @InjectMocks
    private CadastrarPessoa cadastrarPessoa;

    @Test
    void cadastrarPessoa() {

        DadosLocalizacao dadosLocalizacao = new DadosLocalizacao("MG", "Uberaba", "Rua Castro Alves", "Casa", "Nova Floresta");

        Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep(anyString())).thenReturn(dadosLocalizacao);

        Pessoa pessoa = cadastrarPessoa.cadastrarPessoa("José", "28578527976", LocalDate.of(1947, 1, 15), "69317300");

        DadosLocalizacao enderecoPessoa = pessoa.getEndereco();
        assertEquals(dadosLocalizacao.getBairro(), enderecoPessoa.getBairro());
        assertEquals(dadosLocalizacao.getCidade(), enderecoPessoa.getCidade());
        assertEquals(dadosLocalizacao.getUf(), enderecoPessoa.getUf());
    }

    @Test
    void tentaCadastrarPessoaMasSistemaDosCorreiosFalha() {

        //quando a api dos correios for chamada voce lança uma exceptions
        Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep(anyString())).thenThrow(RuntimeException.class);

        Assertions.assertThrows(RuntimeException.class, () -> cadastrarPessoa.cadastrarPessoa("José", "28578527976", LocalDate.of(1947, 1, 15), "69317300"));
    }

}
