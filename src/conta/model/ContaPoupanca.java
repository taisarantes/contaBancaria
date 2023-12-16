package conta.model;

public class ContaPoupanca extends Conta {
	int aniversario;

	// Construtor com herança
	public ContaPoupanca(int numero, int agencia, int tipo, String titular, float saldo, int aniversario) {
		super(numero, agencia, tipo, titular, saldo);
		this.aniversario = aniversario;
	}

	// ---------------------------------------------------------------------
	// Getters e setters
	public int getAniversario() {
		return aniversario;
	}

	public void setAniversario(int aniversario) {
		this.aniversario = aniversario;
	}
	// ---------------------------------------------------------------------
	
	// Método visualizar com polimorfismo
	public void visualizar() {
		super.visualizar();
		System.out.println("Tipo da conta:   1 - Conta Poupança");
		System.out.println("*********************************************");
		System.out.println("Aniversário:    " + this.aniversario);
		System.out.println("*********************************************");
	}

}
