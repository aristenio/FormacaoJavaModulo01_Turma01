package br.com.cepep.formacaojava.heranca;

public class Presidente extends Funcionario implements AutenticavelToken {

	@Override
	public double getBonificacoes() {
		return getSalario() * 2;
	}
	
	public boolean autentica(int senha){
		if (senha > 2)
			return true;
		else
			return false;
	}

	public boolean autenticaToken(int senha){
		if (senha > 2)
			return true;
		else
			return false;
	}

}
