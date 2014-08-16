package br.com.cepep.formacaojava.heranca;

public class Vendedor extends Funcionario {
	
	private int comissao;

	public int getComissao() {
		return comissao;
	}

	public void setComissao(int comissao) {
		this.comissao = comissao;
	}

	@Override
	public double getBonificacoes() {
		return (this.getSalario() + this.comissao) * 1.2;
	}
	
	
}
