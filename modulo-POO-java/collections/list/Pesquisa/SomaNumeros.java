package Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {
  private List<Integer> numeros;

  public SomaNumeros() {
    this.numeros = new ArrayList<>();
  }

  public void adicionarNumero(int numero) {
    numeros.add(numero);
  }

  public int calcularSoma() {
    int soma = numeros.stream().reduce(0,  (subtotal, elemento) -> subtotal + elemento); 
    return soma;
  }

  public int encontrarMaiorNumero() {
    //se a for maior que b então retorne a, se não retorne b
    if (!numeros.isEmpty()) {
      int maiorNumero = numeros.stream().reduce(0, (a, b) -> a > b ? a : b);
      return maiorNumero;
    } else {
      throw new RuntimeException("A lista está vazia!");
    }
  }

  public int encontrarMenorNumero() {
    if (!numeros.isEmpty()) {
      int menorNumero = numeros.stream().reduce(0, (a, b) -> a < b ? a : b);
      return menorNumero;
    } else {
      throw new RuntimeException("A lista está vazia!");
    }
  }

  public void exibirNumeros() {
    if (!numeros.isEmpty()) {
      System.out.println(this.numeros);
    } else {
      System.out.println("A lista está vazia!");
    }
  }
  public static void main(String[] args) {
    // Criando uma instância da classe SomaNumeros
    SomaNumeros somaNumeros = new SomaNumeros();

    // Adicionando números à lista
    somaNumeros.adicionarNumero(5);
    somaNumeros.adicionarNumero(0);
    somaNumeros.adicionarNumero(0);
    somaNumeros.adicionarNumero(-2);
    somaNumeros.adicionarNumero(10);

    // Exibindo a lista de números adicionados
    System.out.println("Números adicionados:");
    somaNumeros.exibirNumeros();

    // Calculando e exibindo a soma dos números na lista
    System.out.println("Soma dos números = " + somaNumeros.calcularSoma());

    // Encontrando e exibindo o maior número na lista
    System.out.println("Maior número = " + somaNumeros.encontrarMaiorNumero());

    // Encontrando e exibindo o menor número na lista
    System.out.println("Menor número = " + somaNumeros.encontrarMenorNumero());
  }
}
