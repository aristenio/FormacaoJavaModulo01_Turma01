package br.com.cepep.formacaojava.heranca;

public class SistemaInterno {
	
	static void login(Autenticavel a){
		a.autentica(5);
	}
	
	public static void main(String[] args) {
		Autenticavel d = new Diretor();
		Autenticavel g = new Gerente();
		
		login(g);
		login(d);
		
		Cliente cliente = new Cliente();
		login(cliente);
	}

}
