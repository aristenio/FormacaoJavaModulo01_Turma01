package br.com.cepep.formacaojava.heranca;

public abstract class FuncionarioAutenticavel extends Funcionario{
	
	public boolean autentica(int senha){
		if (senha > 2)
			return true;
		else
			return false;
	}

}
