package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository {
	ArrayList<Conta> listaContas = new ArrayList<>();
	// Var para armzenar o número da última conta criada:
	int numUltimaConta = 0;

	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			conta.visualizar();
		} else {
			System.out.println("A conta número " + numero + " não foi encontrada!"
					+ " Tente outro número.");
		}
	}

	@Override
	public void listarTodas() {
		if(listaContas.isEmpty()) {
			System.out.println("No momento não há nenhuma conta cadastrada!");
			System.out.println("Digite 1 para cadastrar uma conta.");
		} else {
			for(var conta : listaContas) {
				conta.visualizar();
			}
		}
		
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("A conta número " + conta.getNumeroConta()
								+ " foi criada com sucesso!");
	}

	@Override
	public void atualizar(Conta conta) {
		var buscaConta = buscarNaCollection(conta.getNumeroConta());
		
		if(buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta), conta);
			System.out.println("A conta número " + conta.getNumeroConta()
			                         + " foi atualizada com sucesso!");
		} else {
			System.out.println("A conta número " + conta.getNumeroConta() 
							+ " não foi encontrada! Tente outro número.");
		}
	}

	@Override
	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			if(listaContas.remove(conta)) {
				System.out.println("A conta numero " + numero 
										+ " foi deletada com sucesso!");
			} 
		} else {
			System.out.println("A conta número " + numero 
					+ " não foi encontrada! Tente outro número.");
		}
	}

	@Override
	public void sacar(int numero, float valor) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			if(conta.sacar(valor)) {
				System.out.println("O saque na conta " + numero 
										+ " foi efetuado com sucesso!");
				System.out.println("O saldo da conta " + numero 
										+ " agora é: " + conta.getSaldo());
			}
		}  else {
			System.out.println("A conta número " + numero 
					+ " não foi encontrada! Tente outro número.");
		}
	}

	@Override
	public void depositar(int numero, float valor) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			conta.depositar(valor);
			System.out.println("O depóaito na conta numero " + numero 
					+ " foi efetuado com sucesso!");
			System.out.println("O saldo da conta " + numero 
					+ " agora é: " + conta.getSaldo());
		} else {
			System.out.println("A conta número " + numero 
					+ " não foi encontrada! Tente outro número.");
		}
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		var contaOrigem = buscarNaCollection(numeroOrigem);
		var contaDestino = buscarNaCollection(numeroDestino);
		
		if(contaOrigem != null && contaDestino != null) {
			if(contaOrigem.sacar(valor)) {
				contaDestino.depositar(valor);
				System.out.println("A tranferência foi efetuada com sucesso!");
			}
		} else {
			if(contaOrigem == null) {
				System.out.println("A conta de origem não foi encontrada!");
			} else if(contaDestino == null) {
				System.out.println("A conta de destino não foi encontrada!");
			}
		}
	}
	
	public int gerarNumero() {
		return ++ numUltimaConta;
		
		//  Na prática, este Método simula a Chave Primária de um Banco de dados,
		// do tipo auto-incremento.
	}
	
	public Conta buscarNaCollection(int numero) {
		for(var conta : listaContas) {
			if(conta.getNumeroConta() == numero) {
				return conta;
			} 
		}
		
		return null;
	}
	

}
