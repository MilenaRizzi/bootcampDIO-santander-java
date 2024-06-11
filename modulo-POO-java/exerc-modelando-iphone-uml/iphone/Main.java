public class Main {
  public static void main(String[] args) {
    iPhone meuIphone = new iPhone();

    // Utilizando as funcionalidades de ReprodutorMusical
    meuIphone.selecionarMusica("Imagine - John Lennon");
    meuIphone.tocar();
    meuIphone.pausar();

    // Utilizando as funcionalidades de AparelhoTelefonico
    meuIphone.ligar("123-456-7890");
    meuIphone.atender();
    meuIphone.iniciarCorreioVoz();

    // Utilizando as funcionalidades de NavegadorInternet
    meuIphone.exibirPagina("https://www.example.com");
    meuIphone.adicionarNovaAba();
    meuIphone.atualizarPagina();
  }
}
