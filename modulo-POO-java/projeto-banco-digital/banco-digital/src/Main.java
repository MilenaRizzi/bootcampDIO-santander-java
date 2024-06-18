
public class Main {

	public static void main(String[] args) {
		Cliente bianca = new Cliente();
		bianca.setNome("Bianca");
		
		Conta cc = new ContaCorrente(bianca);
		Conta poupanca = new ContaPoupanca(bianca);

		cc.depositar(100);
		cc.transferir(100, poupanca);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
	}

}
