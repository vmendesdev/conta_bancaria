package conta;

import java.util.Scanner;

import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner leia = new Scanner(System.in);
		
		int opcao;
		
		//Teste da Classe Conta
		Conta c1 = new Conta(1,123, 1, "Adriana", 10000.0f);
		c1.visualizar();
		c1.sacar(12000.0f);
		c1.visualizar();
		c1.depositar(5000.0f);
		c1.visualizar();
		
		//Teste da Conta Corrente
		ContaCorrente cc1 = new ContaCorrente (2, 123, 1, "Mariana", 15000.0f, 1000.0f);
		c1.visualizar();
		c1.sacar(12000.0f);
		c1.visualizar();
		c1.depositar(5000.0f);
		c1.visualizar();
		
		//Teste da Conta Poupança
		ContaPoupanca cp1 = new ContaPoupanca(3,123, 2, "Victor", 100000.0f, 15);
		c1.visualizar();
		c1.sacar(1000.0f);
		c1.visualizar();
		c1.depositar(5000.0f);
		c1.visualizar();

		while (true) {
			
			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND + "***************************************************");
			System.out.println("                                                  ");
			System.out.println("                BANCO DO BRAZIL                   ");
			System.out.println("                                                  ");
			System.out.println("***************************************************");
			System.out.println("\n1 - Criar conta");
			System.out.println("2 - Listar todas as Contas ");
			System.out.println("3 - Buscar Conta por número ");
			System.out.println("4 - Atualizar Dados da Conta ");
			System.out.println("5 - Apagar Conta ");
			System.out.println("6 - Sacar ");
			System.out.println("7 - Depositar ");
			System.out.println("8 - Transferir valores entre Contas ");
			System.out.println("9 - Sair ");
			System.out.println("*************************************************");
			System.out.println("                                                  ");
			System.out.println("\nEntre com a opção desejada: " + Cores.TEXT_RESET);
			  
			opcao = leia.nextInt();
			
			if (opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco do Brazil com Z - O seu futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
				
			}
			
			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Criar Conta\n\n");
				
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todas as contas\n\n");
				
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Consultar dados da conta\n\n");
				
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar dados da conta\n\n");
				
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Apagar a conta\n\n");
				
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Saque\n\n");
				
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Depósito\n\n");
				
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Transferência entre contas\n\n");
				
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n");
				
				break;
			}
	   }
	}
	private static void sobre() {
		// TODO Auto-generated method stub
		System.out.println("\n*******************************************************");
		System.out.println("Projeto Desenvolvido por: Vanessa Mendes");
		System.out.println("Generation Brasil - generation@generation.org");
		System.out.println("github.com/vmendesdev");
		System.out.println("********************************************************");
	}

	}

