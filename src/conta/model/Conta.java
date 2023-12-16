package conta.model;

public class Conta {
	private int numeroConta;
	private int agencia;
	private int tipo;
	private String titular;
	private float saldo;
	
	// Construtor
	public Conta(int numero, int agencia, int tipo, String titular, float saldo){
		this.numeroConta = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
	}

	// ---------------------------------------------------------------------
	// Getters e setters
	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	// ---------------------------------------------------------------------
	
	public boolean sacar(float valor) {
		if(this.getSaldo() < valor) {
			System.out.println("Saldo insuficiente para sacar o valor de R$ " + valor);
			return false;
		}
		this.setSaldo(this.getSaldo() - valor);
		return true;
	}
	
	public void depositar(float valorDepositado) {
		this.setSaldo(this.getSaldo() + valorDepositado);
	}
	
	public void visualizar() {
		System.out.println("\n*********************************************");
		System.out.println("Número da conta: " + this.numeroConta);
		System.out.println("*********************************************");
		System.out.println("Agencia:         " + this.agencia);
		System.out.println("*********************************************");
		System.out.println("Titular:         " + this.titular);
		System.out.println("*********************************************");
		System.out.println("Saldo da conta:  " + this.saldo);
		System.out.println("*********************************************");
	}

}
