package br.com.cepep.formacaojava.sistemabancario;

public class Validacoes {
	
	public static boolean validaCPF(String cpf){
		if(cpf.length()<11)
			return false;
		
		return true;
	}

}
