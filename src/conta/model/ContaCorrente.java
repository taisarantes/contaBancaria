package conta.model;

public class ContaCorrente extends Conta{
	private float limite;

	// Construtor com herança
	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite = limite;
	}

	// ---------------------------------------------------------------------
	// Getters e setters
	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}
	// ---------------------------------------------------------------------
	
	@Override
	public boolean sacar(float valor) {
		if(this.getSaldo() < valor) {
			if(this.getSaldo() == 0) {
				if(this.getLimite() < valor) {
					System.out.println("Seu limite não é suficiente para sacar o valor de " + valor);
				}
			}
			System.out.println("Saldo insuficiente para sacar o valor de R$ " + valor);
			return false;
		}
		this.setSaldo(this.getSaldo() - valor);
		return true;
	}
	
	// Método visualizar com polimorfismo
	public void visualizar() {
		super.visualizar();
		System.out.println("Tipo da conta:    1 - Conta Corrente");
		System.out.println("*********************************************");
		System.out.println("Limite de crédito: " + this.limite);
		System.out.println("*********************************************");
	}
	

}
