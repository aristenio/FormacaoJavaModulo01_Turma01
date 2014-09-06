package br.com.cepep.formacaojava.sistemabancario.model;

public class Endereco {
	
	private String tipo;
	private String logradouro;
	private int numero;
	private String complemento;
	private String CEP;
	
	public Endereco(String tipo, String logradouro, int numero, String complemento) {
		this.tipo = tipo;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
	}
	
	public Endereco(String tipo, String logradouro, int numero) {
		this(tipo,logradouro,numero,"");
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}
	
	
	
}
