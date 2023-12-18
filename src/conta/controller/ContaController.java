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
								+ "foi criada com sucesso!");
	}

	@Override
	public void atualizar(Conta conta) {
		
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
	

}