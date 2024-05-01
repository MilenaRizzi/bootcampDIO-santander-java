import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, digite o número da Conta!");
        int conta = scanner.nextInt();

        System.out.println("Por favor, digite o número da Agência!");
        String agencia = scanner.next();
        scanner.nextLine();

        System.out.println("Por favor, digite o Nome do Cliente!");
        String nome = scanner.nextLine();

        System.out.println("Por favor, digite o Saldo!");
        Float saldo = scanner.nextFloat();

        System.out.println("Olá " + nome + ", obrigado por criar uma conta em nosso banco, sua agencia é " + agencia + ", conta " + conta + " e seu saldo de " + saldo + " já está disponível para saque.");
    }
}
