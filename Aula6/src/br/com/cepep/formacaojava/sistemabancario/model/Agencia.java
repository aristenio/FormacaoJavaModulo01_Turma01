package br.com.cepep.formacaojava.sistemabancario.model;

public class Agencia {
	
	private String numero;
	private ContaBancaria[] contas = new ContaBancaria[20];
	
	public void adicionarConta(ContaBancaria contaBancaria){
		for (int i = 0; i < contas.length; i++) {
			if(contas[i] == null){
				contas[i] = contaBancaria;
				break;
			}
		}
	}

	public ContaBancaria consultarConta(int numeroConta) {
		
		for (ContaBancaria contaBancaria : contas) {
			if(contaBancaria.getNumeroConta() == numeroConta)
				return contaBancaria;
		}
		
		return null;
	}
	
	public static Agencia[] criarAgencias(){
		Agencia[] agencias = new Agencia[5];
		Agencia agenciaCentro = new Agencia();
		agenciaCentro.setNumero("001");

		Agencia agenciaBenfica = new Agencia();
		agenciaBenfica.setNumero("002");
		
		agencias[0] = agenciaCentro;
		agencias[1] = agenciaBenfica;
		
		return agencias;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
}
