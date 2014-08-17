package br.com.cepep.formacaojava.heranca;

import br.com.cepep.formacaojava.heranca.Autenticavel;
import br.com.cepep.formacaojava.sistemabancario.util.Validacoes;

public class Cliente implements Autenticavel{
	
	public static int contador;
//	private static int contador; //static tb pode ser private, mas s� ser� visivel dentro dos objetos
	
	private String nome;
	private String sobrenome;
	private String cpf;
	
	public Cliente(String nome, String sobrenome, String cpf) {
		setNome(nome);
		this.sobrenome = sobrenome;
		setCpf(cpf);
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

	@Override
	public boolean autentica(int senha) {
		if (senha == 123)
			return true;
		else
			return false;
	}
	
	
	
	
}
