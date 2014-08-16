package br.com.cepep.formacaojava.heranca;

public class ControleBonificacoes {
	
	private double totalBonificacoes = 0;
	
	public void registra(Funcionario funcionario){
		System.out.println("Adicionando banificação do funcionario "+funcionario.getNome());
		this.totalBonificacoes += funcionario.getBonificacoes();
	}

	public double getTotalBonificacoes() {
		return totalBonificacoes;
	}

}
