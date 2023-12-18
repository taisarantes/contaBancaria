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
		for(var conta : listaContas) {
			conta.visualizar();
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
			System.out.println("\nA conta número " + conta.getNumeroConta()
			                         + " foi atualizada com sucesso!");
		} else {
			System.out.println("A conta número " + conta.getNumeroConta() 
							+ " não foi encontrada! Tente outro número.");
		}
	}

	@Override
	public void deletar(int numero) {
		
	}

	@Override
	public void sacar(int numero, float valor) {
		
	}

	@Override
	public void depositar(int numero, float valor) {
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		
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
