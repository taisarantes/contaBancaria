package conta;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {
	public static void main(String[] args) {
		int opcao;
		int numero, agencia, tipo, aniversario = 0;
		String titular;
		float saldo, limite;
		Scanner leia = new Scanner(System.in);
		ContaController contas = new ContaController();
		
		
		exibirMenu();
		do {
			System.out.print("\nDigite a opção desejada: ");
			
			try {
				opcao = leia.nextInt();
				leia.nextLine();
			}catch(InputMismatchException e){
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao=0;
			}
			
			switch(opcao) {
			case 1:
				System.out.println("Criar Conta\n");
				
				System.out.print("Digite o nome do titular da conta: ");
				titular = leia.nextLine(); 
				System.out.print("Digite o saldo da conta: ");
				saldo = leia.nextFloat();
				System.out.print("Digite o número da agencia da conta: ");
				agencia = leia.nextInt();
				
				do {
					System.out.println("Digite o tipo da conta: ");
					System.out.print("Sendo: 1 - Conta corrente ou 2 - Conta poupança. ");
					tipo = leia.nextInt();
					if(tipo != 1 && tipo != 2) {
						System.out.println("Tipo inválido!");
					}
				} while(tipo < 1 || tipo > 2);
				
				switch(tipo) {
				case 1: 
					System.out.print("Digite o limite da conta: ");
					limite = leia.nextInt();
					
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), 
										agencia, tipo, titular, saldo, limite));
					
					break;
				case 2: 
					System.out.print("Digite seu aniversario: ");
					aniversario = leia.nextInt();
					
					contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), 
										agencia, tipo, titular, saldo, aniversario));
					
					break;
				}
				

				keyPress();
				break;
			case 2:
				System.out.println("Listar todas as Contas\n");
				contas.listarTodas();
			

				keyPress();
				break;
			case 3:
				System.out.println("Consultar dados da Conta - por número\n");
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				contas.procurarPorNumero(numero);

				
				keyPress();
				break;
			case 4:
				System.out.println("Atualizar dados da Conta\n\n");
				System.out.println("Digite o número da conta para ser atualizada: ");
				numero = leia.nextInt();
				leia.nextLine();
				var buscaConta = contas.buscarNaCollection(numero);
				
				if(buscaConta != null) {
					tipo = buscaConta.getTipo();
					
					System.out.print("Digite o nome do titular da conta: ");
					titular = leia.nextLine(); 
					System.out.print("Digite o saldo da conta: ");
					saldo = leia.nextFloat();
					System.out.print("Digite o número da agencia da conta: ");
					agencia = leia.nextInt();
					
					do {
						System.out.println("Digite o tipo da conta: ");
						System.out.print("Sendo: 1 - Conta corrente ou 2 - Conta poupança. ");
						tipo = leia.nextInt();
						if(tipo != 1 && tipo != 2) {
							System.out.println("Tipo inválido!");
						}
					} while(tipo < 1 || tipo > 2);
					
					switch(tipo) {
					case 1: 
						System.out.print("Digite o limite da conta: ");
						limite = leia.nextInt();
						
						contas.cadastrar(new ContaCorrente(contas.gerarNumero(), 
											agencia, tipo, titular, saldo, limite));
						
						break;
					case 2: 
						System.out.print("Digite seu aniversario: ");
						aniversario = leia.nextInt();
						
						contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), 
											agencia, tipo, titular, saldo, aniversario));
						
						break;
					}
				} else {
					System.out.println("A conta não foi encontrada!");
				}

				
				keyPress();
				break;
			case 5:
				System.out.println("Apagar a Conta\n\n");

				
				keyPress();
				break;
			case 6:
				System.out.println("Saque\n\n");

				
				keyPress();
				break;
			case 7:
				System.out.println("Depósito\n\n");

				
				keyPress();
				break;
			case 8:
				System.out.println("Transferência entre Contas\n\n");

				
				keyPress();
				break;
			case 9:
				System.out.println(Cores.TEXT_CYAN_BOLD_BRIGHT +
						"\nBanco do Brazil Padar - O seu Futuro começa aqui!" + Cores.TEXT_RESET);
				sobre();
				leia.close();
				System.exit(0);
				
				break;
			default: 
				System.out.println("Opção invalida! Por favor tente novamente.");
			}
			
		} while(opcao != 9);
	}
	
	public static void exibirMenu() {
		System.out.println(Cores.TEXT_GREEN + 
				           "*********************************************");
		System.out.println("                                             ");
		System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + 
				           "            BANCO DO BRAZIL PADAR            ");
		System.out.println("                                             ");
		System.out.println(Cores.TEXT_RESET + Cores.TEXT_GREEN + 
				           "*********************************************");
		System.out.println("                                             ");
		System.out.println("     1 - Criar conta                         ");
		System.out.println("     2 - Listar todas as contas              ");
		System.out.println("     3 - Buscar conta por número             ");
		System.out.println("     4 - Atualizar dados da conta            ");
		System.out.println("     5 - Apagar conta                        ");
		System.out.println("     6 - Scar                                ");
		System.out.println("     7 - Depositar                           ");
		System.out.println("     8 - Transferir valores entre contas     ");
		System.out.println("     9 - Sair                                ");
		System.out.println("                                             ");
		System.out.println("*********************************************" 
		                 + Cores.TEXT_RESET);
		
	}
	
	public static void sobre() {
		System.out.println(Cores.TEXT_CYAN_BRIGHT + 
		                 "\n*********************************************");
		System.out.println("- Projeto Desenvolvido por: ");
		System.out.println("- Tais Arantes - tais.reis.arantes@gmail.com");
		System.out.println("- github.com/taisarantes");
		System.out.println("*********************************************");
	}
	
	public static void keyPress() {
		try {
		System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
		System.in.read();

		} catch (IOException e) {
		System.out.println("Você pressionou uma tecla diferente de enter!");

		}
	}
}
