
public class Cliente {
	// couter é para contar e inicia do 1
	private static int counter = 1;
	private String nome;
	private String cpf;
	private String email;

//Construtor
	public Cliente(String nome, String cpf, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
//toda vez que for cadastrar uma nova conta soma +=1;
		counter += 1;
	}

	public static int getCounter() {
		return counter;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}

	public static void setCounter(int counter) {
		Cliente.counter = counter;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//Método para retornar, saída dos dados da conta sendo nome,cpf etc...
//ele traz uma representação textual de 
//uma instância de um objeto.	
	public String toString() {
				return " \nNome: "
				+ this.getNome() + 
				" \nCPF: " + this.getCpf() +
				" \nE-mail: " + this.getEmail();

	}
}
