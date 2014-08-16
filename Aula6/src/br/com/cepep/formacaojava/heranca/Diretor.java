package br.com.cepep.formacaojava.heranca;

public class Diretor extends Gerente {
	
	public int getCodigoCofre() {
		return 0;
	}

	public void setCodigoCofre(int codigoCofre) {
	}

	public String quemEhVoce(){
		return super.quemEhVoce() +" e Sou o Diretor";
	}
	
	public boolean autentica(int senha){
		if (senha > 2)
			return true;
		else
			return false;
	}
}
