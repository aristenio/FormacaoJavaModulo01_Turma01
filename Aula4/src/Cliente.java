
public class Cliente {
	
	String nome;
	String sobrenome;
	String cpf;
	Endereco endereco;
	
	public Cliente(String nome, String sobrenome, String cpf, Endereco endereco) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.endereco = endereco;
	}

	public Cliente() {

	}
}
