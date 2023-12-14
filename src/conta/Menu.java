package conta;

import java.util.Scanner;
import conta.util.Cores;

public class Menu {
	public static void main(String[] args) {
		int opcao;
		Scanner leia = new Scanner(System.in);
		
		exibirMenu();
		do {
			System.out.println("Digite a opção desejada: ");
			opcao = leia.nextInt();
			
			switch(opcao) {
			case 1:
				System.out.println("Criar Conta\n\n");

				break;
			case 2:
				System.out.println("Listar todas as Contas\n\n");

				break;
			case 3:
				System.out.println("Consultar dados da Conta - por número\n\n");

				break;
			case 4:
				System.out.println("Atualizar dados da Conta\n\n");

				break;
			case 5:
				System.out.println("Apagar a Conta\n\n");

				break;
			case 6:
				System.out.println("Saque\n\n");

				break;
			case 7:
				System.out.println("Depósito\n\n");

				break;
			case 8:
				System.out.println("Transferência entre Contas\n\n");

				break;
			case 9:
				System.out.println(Cores.TEXT_WHITE_BOLD +
						"\nBanco do Brazil Padar - O seu Futuro começa aqui!");
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
}
