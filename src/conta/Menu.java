package conta;

import java.util.Scanner;

import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner leia = new Scanner(System.in);
		
		int opcao;
		

		while (true) {
			
			System.out.println("***************************************************");
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
			System.out.println("\nEntre com a opção desejada: ");
			  
			opcao = leia.nextInt();
			
			if (opcao == 9) {
				System.out.println("");
				sobre();
				leia.close();
				System.exit(0);
				
			}
			
			switch (opcao) {
			case 1:
				System.out.println("");
				
				break;
			case 2:
				System.out.println("");
				
				break;
			case 3:
				System.out.println("");
				
				break;
			case 4:
				System.out.println("");
				
				break;
			case 5:
				System.out.println("");
				
				break;
			case 6:
				System.out.println("");
				
				break;
			case 7:
				System.out.println("");
				
				break;
			case 8:
				System.out.println("");
				
				break;
			default:
				System.out.println("");
				
				break;
			}
	   }
	}
	private static void sobre() {
		// TODO Auto-generated method stub
		System.out.println("\n*******************************************************");
		System.out.println("Projeto Desenvolvido por: Vanessa Mendes");
		System.out.println("Generation Brasil ");
		System.out.println("github.com/vmendesdev");
		System.out.println("********************************************************");
	}

	}

