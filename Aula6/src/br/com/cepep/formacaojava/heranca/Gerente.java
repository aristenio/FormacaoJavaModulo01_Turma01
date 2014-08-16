package br.com.cepep.formacaojava.heranca;

public class Gerente extends Funcionario implements Autenticavel {
	
	private int codigoCofre;

	public int getCodigoCofre() {
		return codigoCofre;
	}

	public void setCodigoCofre(int codigoCofre) {
		this.codigoCofre = codigoCofre;
	}

	@Override
	public double getBonificacoes() {
		return this.getSalario() * 1.2;
	}

	@Override
	public boolean autentica(int senha) {
		if(senha >2)
			return true;
		else
			return false;
	}
	
	
	
	
}
