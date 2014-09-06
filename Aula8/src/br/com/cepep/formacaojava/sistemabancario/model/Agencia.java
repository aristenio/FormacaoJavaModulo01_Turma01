package br.com.cepep.formacaojava.sistemabancario.model;

import br.com.cepep.formacaojava.sistemabancario.exception.AgenciaNaoEncontradaException;
import br.com.cepep.formacaojava.sistemabancario.exception.ContaBancariaNaoEncontradaException;
import br.com.cepep.formacaojava.sistemabancario.util.Repositorio;

/**
 * Classe que define a entidade agencia
 * 
 * @author Aristenio Monteiro Filho
 *
 */
public class Agencia {
	
	private String numero;
	private Repositorio<ContaBancaria> repositorio = new Repositorio<ContaBancaria>("D://Aristenio/dados/contasbancarias.cepep");
	
	/**
	 * Construtor da entidade Agencia, possui o parâmetro @String numero para obrigar que esta entidade sempre seja instaciada 
	 * com a propriedade numero preenchida
	 * @param nome Parametro que será setado na propriedade numero desta entidade 
	 */
	public Agencia(String numero){
		this.numero = numero;
	}
	
	/**
	 * Método que adiciona uma conta bancaria dentro do array de contas bancaria que a entidade possui
	 * @param contaBancaria Conta bancaria a ser inserida no array
	 */
	public void adicionarConta(ContaBancaria contaBancaria){
		repositorio.adicionaObjeto(contaBancaria);
	}

	/**
	 * Método que consulta uma dentre as contas bancaria pertencentes a agencia
	 * @param agencia Numero da conta bancaria a ser consultada
	 * @return Retorna a entidade conta bancaria referente ao numero da conta bancaria informada da consulta
	 * @throws AgenciaNaoEncontradaException Exceção levantada caso a conta bancaria consultada não seja encontrada nesta agencia
	 */
	public ContaBancaria consultarConta(int numeroConta) throws ContaBancariaNaoEncontradaException{
		
		for (ContaBancaria contaBancaria :  repositorio.retornarTodos() ) {
			if(contaBancaria != null && contaBancaria.getNumeroConta() == numeroConta)
				return contaBancaria;
		}
		
		throw new ContaBancariaNaoEncontradaException("Conta bancaria numero: "+numeroConta+" não foi encontrada na agencia "+this.numero);
	}
	
	/**
	 * Método estático utlizado para criar duas agencias para utização en testes
	 * @return Retorna um array de agencia com 5 posições e somente as duas primeiras preenchida
	 */
	public static Agencia[] criarAgencias(){
		Agencia[] agencias = new Agencia[5];
		Agencia agenciaCentro = new Agencia("001");
		Agencia agenciaBenfica = new Agencia("002");
		
		agencias[0] = agenciaCentro;
		agencias[1] = agenciaBenfica;
		
		return agencias;
	}

	public String getNumero() {
		return numero;
	}

}
