
//Com tira dúvidas da prof Alessandra

import utilitarios.Utils;

public class Conta {
	
	//Toda vez que for criada uma conta será atribuído um número em ordem crescente
	//qualquer objeto da classe conta verá a informação
	//private refer-se a comunicação de classes diferentes
	//static comunicação de dados de objetos de uma mesma classe
	private static int contadorDeContas = 0;
	
	private int numeroAgência = 0001;
	private int numeroConta;
	private Cliente cliente;//Fiz um import da classe Cliente
	private Double saldoInicial = 0.00;
	
	
	public Double getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(Double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	// retirou int numeroConta e retirou , Double saldo
	public Conta(Cliente cliente) {
		//alterei de numeroConta para contadorDeContas
		//pois sempre que for criar uma conta vai contar
		
		contadorDeContas +=1;
		this.numeroConta = contadorDeContas; 
		this.cliente = cliente;
		//this.saldo = saldo;//retirou
		
		
		
		
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
 // Esso metodo achei ele mais fácil vi ele no Youtube e implantei,
	// se vc der control + espaço ele aparece automaticamente
	// agora não vai aparecer porq ele já está aqui
	
	public String toString() {
		return 
		"===========================================================================" +	
		   " \n Número da Agência: 000 " + this.getNumeroAgência() +	
		   " \n Número da conta: " + this.getNumeroConta() + 
		   " \n Nome do cliente: " + this.cliente.getNome() + 
		   " \n CPF: " + this.cliente.getCpf() +
		   " \n Email: " + this.cliente.getEmail() +
		   " \n Saldo Inicial: " + Utils.doubleToString(this.getSaldoInicial()) + "\n" +
		"===========================================================================";
		  
		  //Pegou o método da classe utils para formatar o valor do saldo
		// e sair o valor formatado  
			
				
	}
	
	//Implementando métodos de sacar, depositar, transferência
	
	//Método depositar:	
	public void depositar(Double valor) {
		if (valor > 0) {
			setSaldoInicial(getSaldoInicial() + valor);
			System.out.println(" Seu depósito  foi realizado com sucesso! ");
		}else {
			System.out.println(" Não foi possível realizar o depósito! ");
		}
	}
	
	//Médoto sacar:
	
	public void sacar(Double valor) {
		//Precisa saber se o valor a sacar é maior que zero pois não tem
		//saldo negativo e precisa saber se tem saldo suficiente para isso
		if ( valor > 0 &&  this.getSaldoInicial() >= valor) {
			setSaldoInicial(getSaldoInicial() - valor);
			System.out.println(" Saque realizado com sucesso!");
		}else {
			System.out.println(" Não foi possível realizar o saque! ");
			
		}
	}
	
	// Método de transferir:
	
	public void transferir(Conta contaParaDeposito, Double valor) {
		if ( valor > 0 && this.getSaldoInicial() >= valor) { //saldo e valor a ser transferido
			//tem que ser maior do que 0
			setSaldoInicial(getSaldoInicial() - valor);
			
			contaParaDeposito.saldoInicial = contaParaDeposito.getSaldoInicial() + valor;
			System.out.println(" Transferência realizada com sucesso!");
		}else {
			System.out.println(" Não foi possível realizar a transferência!!");
			
		}
	}

	//Método que retorna o rendimento
	
			public double rendimento() {
				
				double rendimentofinal = 0.00;
				rendimentofinal = saldoInicial* 0.05;
				return rendimentofinal;
				
				
			}

			public int getNumeroAgência() {
				return numeroAgência ;
			}

			public void setNumeroAgência(int numeroAgência) {
				this.numeroAgência = numeroAgência;
			}
}


