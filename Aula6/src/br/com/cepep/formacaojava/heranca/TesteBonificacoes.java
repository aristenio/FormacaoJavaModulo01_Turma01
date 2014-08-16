package br.com.cepep.formacaojava.heranca;

public class TesteBonificacoes {
	
	public static void main(String[] args) {
		ControleBonificacoes controleBonificacoes = new ControleBonificacoes();
		
		Funcionario f1 = new Vendedor();
		f1.setNome("Jose");
		f1.setSalario(1000);
		
		controleBonificacoes.registra(f1);
	}

}
