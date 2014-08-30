package br.com.cepep.formacaojava.sistemabancario.model;

public class ContaPoupanca extends ContaBancaria {

	public ContaPoupanca(int numeroConta, Cliente cliente) {
		super(numeroConta, cliente);
	}

	public void atualiza(double taxa){
		this.saldo = (int) (this.saldo * taxa * 2);
	}
}
