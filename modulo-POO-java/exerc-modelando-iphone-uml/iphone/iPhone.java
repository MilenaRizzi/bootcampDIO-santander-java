public class iPhone implements ReprodutorMusical, AparelhoTelefonico, NavegadorInternet{

  @Override
  public void exibirPagina(String url) {
    System.out.println("Exibindo a página: " + url);
  }

  @Override
  public void adicionarNovaAba() {
    System.out.println("Adicionando nova aba no navegador...");
  }

  @Override
  public void atualizarPagina() {
    System.out.println("Atualizando a página...");
  }


  @Override
  public void ligar(String numero) {
    System.out.println("Ligando para: " + numero);
  }

  @Override
  public void atender() {
    System.out.println("Atendendo a chamada...");
  }

  @Override
  public void iniciarCorreioVoz() {
    System.out.println("Iniciando o correio de voz...");
  }

  @Override
  public void tocar() {
    System.out.println("Reproduzindo música...");
  }

  @Override
  public void pausar() {
    System.out.println("Pausando música...");

  }

  @Override
  public void selecionarMusica(String musica) {
    System.out.println("Selecionando a música: " + musica);
  }
}