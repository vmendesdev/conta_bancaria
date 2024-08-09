package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;
 
public class Menu {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		ContaController contas = new ContaController();

		Scanner leia = new Scanner(System.in);
		
		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite = 0, valor;

		System.out.println("\nCriar Conta\n");
		/*
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.0f);
		contas.cadastrar(cc1);
		
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 100.0f);
		contas.cadastrar(cc2);
		
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Mariana dos Santos", 4000f, 100.0f, 3);
		contas.cadastrar(cp1);
		
		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 126, 2, "Juliana Ramos", 8000f, 100.0f, 4);
		contas.cadastrar(cp2);*/
		
		contas.listarTodas();
	
		while (true) {
			
			System.out.println(Cores.TEXT_BLUE + Cores.ANSI_WHITE_BACKGROUND + "***************************************************");
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
			
			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}
			
			if (opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco do Brazil com Z - O seu futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
				
			}
			
			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Criar Conta\n\n");
				System.out.println("Digite o número da agência: ");
				agencia = leia.nextInt();
				System.out.println("Digite o Nome do Titular: ");
				leia.skip("\\R?");
				titular = leia.nextLine();
				
				do {
					System.out.println("Digite o Tipo de Conta (1-CC ou 2-CP): ");
					tipo = leia.nextInt();
				} while(tipo < 1 && tipo > 2);
				
				System.out.println("Digite o Saldo da Conta (R$): ");
				saldo = leia.nextFloat();
				
				switch(tipo) {
				case 1 -> {
					System.out.println("Digite o Limite de Crédito (R$): ");
					limite = leia.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				case 2 -> { 
					System.out.println("Digite o dia de Aniversário da Conta: ");
					aniversario = leia.nextInt();
					contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario, 0));
				}
				}
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todas as contas\n\n");
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Buscar Conta por número\n\n");
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				contas.procurarPorNumero(numero);
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar dados da conta\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				var buscaConta = contas.buscaNaCollection(numero);
				
				if(buscaConta != null) {
					
					System.out.println("Digite o número da Agência: ");
					agencia = leia.nextInt();
					System.out.println("Digite o Nome do Titular: ");
					leia.skip("\\R?");
					titular = leia.nextLine();
					
					System.out.println("Digite o Saldo da Conta (R$): ");
					saldo = leia.nextFloat();
					
					tipo = buscaConta.getTipo();
					
					switch (tipo) {
					case 1 -> {
						System.out.println("Digite o Limite de Crédito (R$): ");
						limite = leia.nextFloat();
						contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o dia do Aniversario da Conta: ");
						aniversario = leia.nextInt();
						
						contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, limite, aniversario));
					}
					default -> {
						System.out.println("Tipo de conta inválido!");
					}
					}
				}else {
					System.out.println("A Conta não foi encontrada!");
				}
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Apagar a conta\n\n");
				System.out.println("Digite  número da conta: ");
				numero = leia.nextInt();
				
				contas.deletar(numero);

				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Saque\n\n");
				
				System.out.println("Digite o número da Conta: ");
				numero = leia.nextInt() ;
				
				do {
					System.out.println("Digite o valor do Saque (R$): ");
					valor = leia.nextFloat ();
					
				} while (valor <= 0);
				
				contas.sacar(numero, valor);
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Depósito\n\n");

				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				do {
					System.out.println("Digite o valor de depósito (R$): ");
					valor = leia.nextFloat();
					
				} while (valor <= 0);
				contas.depositar(numero, valor);
				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Transferência entre contas\n\n");

				System.out.println("Digite o numero da conta de origem: ");
				numero = leia.nextInt();
				System.out.println("Digite o numero da conta de destino: ");
				numeroDestino = leia.nextInt();
				
				do {
					System.out.println("Digite o valor da transferência (R$): ");
					valor = leia.nextFloat();
					
				}while (valor <= 0);
				contas.transferir(numero, numeroDestino, valor);
				
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);

				keyPress();
				break;	
				}
			}
 	   }
	private static void sobre() {
		// TODO Auto-generated method stub
		System.out.println("\n*******************************************************");
		System.out.println("Projeto Desenvolvido por: Vanessa Mendes");
		System.out.println("Contato - vanessam.mendes@outlook.com.br");
		System.out.println("github.com/vmendesdev");
		System.out.println("********************************************************");
	}
	private static void keyPress() {
		// TODO Auto-generated method stub
		try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar...");
            System.in.read();
            
		}catch (IOException e) {
			
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}
}
