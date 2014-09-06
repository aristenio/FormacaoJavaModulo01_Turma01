package br.com.cepep.formacaojava.sistemabancario.model;

import br.com.cepep.formacaojava.sistemabancario.util.Validacoes;

public class Cliente implements Comparable<Cliente>{
	
	public static int contador;
//	private static int contador; //static tb pode ser private, mas s� ser� visivel dentro dos objetos
	
	private String nome;
	private String sobrenome;
	private String cpf;
	private Endereco endereco;
	
	public Cliente(String nome, String sobrenome, String cpf, Endereco endereco) {
		setNome(nome);
		this.sobrenome = sobrenome;
		setCpf(cpf);
		this.endereco = endereco;
		if(contador>30)
			enviaEmail();
	}

	private void enviaEmail() {
		// TODO Auto-generated method stub
		
	}

	public Cliente() {
		contador++;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		if(validaCPF(cpf))
			this.cpf = cpf;
	}

	private boolean validaCPF(String cpf) {
		return Validacoes.validaCPF(cpf);
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", sobrenome=" + sobrenome + ", cpf="
				+ cpf + "]";
	}
	
	@Override
	public int compareTo(Cliente o) {
		if(this.nome.compareTo(o.nome) < 0)
			return -1;

		if(this.nome.compareTo(o.nome) > 0)
			return 1;
		
		return 0;
	}

}
