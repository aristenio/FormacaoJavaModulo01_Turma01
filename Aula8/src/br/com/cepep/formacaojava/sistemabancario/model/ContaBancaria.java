package br.com.cepep.formacaojava.sistemabancario.model;

import br.com.cepep.formacaojava.sistemabancario.exception.SaldoInsuficienteException;

public class ContaBancaria implements Comparable<ContaBancaria> {
	
	private int numeroConta;
	private Cliente cliente;
	protected int saldo;
	private int limite;
	
	public ContaBancaria(int numeroConta, Cliente cliente) {
		this.numeroConta = numeroConta;
		this.cliente = cliente;
		this.saldo = 0;
		this.limite = 1000;
	}

	public void deposita(int valor){
		saldo += valor;
	}
	
	public void sacar(int valor) throws SaldoInsuficienteException{
		
		if((saldo + limite) >= valor){
			saldo -= valor;
		}else{
			throw new SaldoInsuficienteException("Saldo insuficiente");
		}
	}
	
	public String retornaInfoConta(){
		String retorno;
		
		retorno="Num. conta = "+numeroConta+"\n";
		retorno+="Nome. correntista = "+this.cliente.getNome()+"\n";
		retorno+="Saldo = "+saldo+"\n";
		retorno+="Limite = "+limite+"\n";
		
		return retorno;
	}
	
	/**
	 * Método utilizado para a transferencia de valores entre contas
	 * @param conta objeto dp tipo @ContaBancaria representando a conta pra onde o valor será transferido 
	 * @param valor valor a ser transferido
	 * @throws SaldoInsuficienteException Execão que ocorre caso não haja saldo suficiente na conta originaria da transferencia
	 */
	public void transfere(ContaBancaria conta, int valor) throws SaldoInsuficienteException{
		
		try {
			this.sacar(valor);	
			conta.deposita(valor);
		} catch (SaldoInsuficienteException e) {
			throw e;
		}
	}
	
	public void atualiza(double taxa){
		this.saldo = (int) (this.saldo * taxa);
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public int consultaSaldo(){
		return this.saldo;
	}

	@Override
	public String toString() {
		return "ContaBancaria [numeroConta=" + numeroConta + ", cliente="
				+ cliente + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numeroConta;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaBancaria other = (ContaBancaria) obj;
		if (numeroConta != other.numeroConta)
			return false;
		return true;
	}
	
	@Override
	public int compareTo(ContaBancaria o) {
		if(this.saldo < o.saldo)
			return -1;
		else if(this.saldo > o.saldo)
			return 1;
		
		return 0;
	}
	
	
}
