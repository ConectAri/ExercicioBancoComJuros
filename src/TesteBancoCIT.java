import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import utilitarios.Utils;

public class TesteBancoCIT {
	
	//static é atributo de classe, informação de que todos objetos da classe
	//consigam ver a informação.
	static Scanner leia = new Scanner(System.in);
	// Como tem várias contas precisa de uma lista de contas
	// logo usar arraylist
	// Chamei o ArrayList , a lista de contasBancarias
	static ArrayList<Conta> contasBancarias;

	public static void main(String[] args) {

		// estanciei a lista
		contasBancarias = new ArrayList<Conta>();
		// Criando menu de operaçoes
		operacoes();
	}

	@SuppressWarnings("unused")
	public static void operacoes() {

		// Configuração para sair na data do dia que for gerado extrato

		Date data = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat(" dd/MM/yyyy");
		String dataFormatada = formatar.format(data);
		
		System.out.println(" ");
		System.out.println(" --------------------------------------------------");
		System.out.println(" -------------- Extrato Bancário-------------------");
		System.out.println(" --------------------------------------------------");
		System.out.println(" ----------------Banco CI&T------------------------");
		System.out.println(" --------------------------------------------------");
		System.out.println(" ------- Data de hoje: " + dataFormatada +"--------");
		System.out.println(" --------------------------------------------------");
		System.out.println(" *** Selecione uma operação que deseja realizar ***");
		System.out.println(" --------------------------------------------------");
		System.out.println("| Opção 1 - Criar conta |");
		System.out.println("| Opção 2 - Depositar   |");
		System.out.println("| Opção 3 - Sacar       |");
		System.out.println("| Opção 4 - Transferir  |");
		System.out.println("| Opção 5 - Listar      |");
		System.out.println("| Opção 6 - Rendimento  |");
		System.out.println("| Opção 7 - Sair        |");
		System.out.println(" ");
		System.out.println(" ");

		// Fazer o Swutch case para chamar cada operação que o usuário optar
		int operacao = leia.nextInt();

		switch (operacao) {
		case 1:
			criarConta();
			break;
		case 2:
			depositar();
			break;
		case 3:
			sacar();
			break;
		case 4:
			transferir();
			break;
		case 5:
			listarContas();
			break;
		case 6:
			rendimento();
			break;
		case 7:
			System.out.println(" Obrigado por ser nosso correntista," + " o Banco CI&T agradece sua preferência!! ");
			System.exit(0);//Determina que o programa está saindo com sucesso
		defaut: //Direcionar a mensagem diferente do que está sendo pedito.
			System.out.println(" Opcão inválida !!!!");
			operacoes();// chamou o menu principal pois não quer sair, dar opção do menu
			
		}
	}

	// Método criar conta:

	public static void criarConta() {

		System.out.println("\nNome do cliente: ");
		String nome = leia.next();
			
		System.out.println("\nCPF: ");
		String cpf = leia.next();
					
		System.out.println(" \nE-mail: ");
		String email = leia.next();
		
		// estancio a class cliente
		Cliente cliente = new Cliente(nome, cpf, email);

		// Adicionando no novo cliente a conta:
		// resgato a Class conta para adicionar o cliente
		Conta conta = new Conta(cliente);

		// Aqui ao olhar na linha 12 chamei o nome da lista do array de contasbancarias
		// e agora estou adicinando o cliente da linha 97 a classe conta
		contasBancarias.add(conta);
		System.out.println(" Parabéns, sua conta foi criada com sucesso!!");

		// Chama o método operacoes novamente para criar a opção de
		// encontrar número de conta quando for criada
		operacoes();

	}

	// MÉTODO DE ENCONTRAR CONTAS:

	// Chamei o novo método de encontrar conta que vai receber um número de uma
	// conta
	// no qual o usuário irá digitar ao criar
	private static Conta encontrarConta(int numeroConta) {
		
		Conta conta = null;
		// Definiu como null porque se a conta NÃO existir irá retornar
		// e vai dizer conta não encontrada
		if (contasBancarias.size() > 0) {
			// Para cada conta dentro de contasbancarias
			for (Conta c : contasBancarias) {
				if (c.getNumeroConta() == numeroConta) {
					// Se a conta c criada dentro da conta
				    // bancária for igual ao número de conta que o usuário digitou
				    // a minha conta irá receber a conta c
				   conta = c;
				   break;
				}
			}
		}
		return conta;
	

	}

	// Método DEPOSITAR:

	public static void depositar() {
		System.out.print(" Número da conta: ");
		int numeroConta = leia.nextInt();
		// Faz a busca e olha para encontrar
		Conta conta = encontrarConta(numeroConta);

		// Fazer validações se a conta irá encontrar
		if (conta != null) {
			System.out.println(" Qual valor deseja depositar? R$ ");
			Double valorDeposito = leia.nextDouble();
			conta.depositar(valorDeposito);
			System.out.println(" Valor R$  " + valorDeposito + " depositado com sucesso! ");
		} else {
			System.out.println(" Conta " + numeroConta + " não encontrada! ");
		}
		operacoes();// Para retornar ao menu de opções
	}

	// Método Sacar:

	public static void sacar() {
		// pede usuário número de uma conta
		System.out.print(" Número da conta: ");
		// armazena o número que usuário digitou
		int numeroConta = leia.nextInt();
		// olha se a conta digitada existe
		Conta conta = encontrarConta(numeroConta);
		// faz a validação
		if (conta != null) {
			System.out.println(" Qual valor deseja sacar? R$ ");
			Double valorSaque = leia.nextDouble();
			// vai para o método sacar que está na classe Conta e valida as informações
			conta.sacar(valorSaque);
			System.out.println(" Valor R$  " + valorSaque + " sacado com sucesso! ");
		} else {
			System.out.println(" Conta " + numeroConta + " não encontrada! ");
		}
		operacoes();
	}

	public static void transferir() {
		System.out.println(" Número da conta a ser debitada (remetente)? ");
		int numeroContaRemetente = leia.nextInt();
		// Aqui instanciei e crei o objeto contaRemetente e fiz a busca se ela existe
		Conta contaRemetente = encontrarConta(numeroContaRemetente);

		if (contaRemetente != null) {
			// Se a conta for diferente de null e se ela existir dar continuidade abaixo
			System.out.println(" Número da conta do destinatário (valor a ser creditado): ");
			int numeroContaDestinatario = leia.nextInt();
			// Aqui criei o objeto contaDestinatario para dentro da classe Conta loca-
			// -lizar o numeroContaDestinatario por meio do método encontrarConta
			Conta contaDestinatario = encontrarConta(numeroContaDestinatario);
			// faço a validação
			if (contaDestinatario != null) {
				System.out.println(" Qual o valor da transferência? R$ ");
				double valor = leia.nextDouble();

				// Pego a contaRemetente, chamo o metodo transferir,
				// passo a conta do destinatário e o valor a ser transferido
				contaRemetente.transferir(contaDestinatario, valor);
			}else {
				System.out.println(" A conta para depósito não foi encontrada");
			}
		}else {
			System.out.println(" Conta para transferência não encontrada ");
					
		}
		operacoes();
	} 
	
	//Método listarContas
	
	public static void listarContas() {
		//Se a lista for maior que zero, percorre a lista 
		//para cada conta imprima cada uma delas dentro da lista
		if (contasBancarias.size() > 0) {
			
			for(Conta conta: contasBancarias){
				System.out.println(conta);
			}
			
		} else {
				System.out.println("Não há contas cadastradas");
				
		}
		operacoes();
    }
	
	//Método rendimento
	
	public static void rendimento() {
		// pede usuário número de uma conta
		System.out.print(" Número da conta: ");
		// armazena o número que usuário digitou
		int numeroConta = leia.nextInt();
		// olha se a conta digitada existe
		Conta conta = encontrarConta(numeroConta);
		// faz a validação
		if (conta != null) {
			//pegar o método da classe conta que faz o calculo do rendimento
		double rendimento = conta.rendimento();			//Aqui para fazer a formatação do rendimento 
			System.out.println(" Prévia do rendimento R$  " + Utils.doubleToString(rendimento));
		} else {
			System.out.println(" Conta " + numeroConta + " não encontrada! ");
		}
		operacoes();
	}
}
