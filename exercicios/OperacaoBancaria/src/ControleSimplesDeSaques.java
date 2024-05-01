import java.util.Scanner;

public class ControleSimplesDeSaques {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    double limiteDiario = scanner.nextDouble();

    for (int i = 0; i < limiteDiario; i++) {
      double valorSaque = scanner.nextDouble();
      if (valorSaque == 0) {
        break;
      }
      if (valorSaque > limiteDiario) {
        System.out.println("Limite diario de saque atingido. Transacoes encerradas.");
        break;
      }

      limiteDiario -= valorSaque;
      System.out.println("Saque realizado. Limite restante: " + limiteDiario + "\n Transacoes encerradas.");

    }
    scanner.close();
  }
}