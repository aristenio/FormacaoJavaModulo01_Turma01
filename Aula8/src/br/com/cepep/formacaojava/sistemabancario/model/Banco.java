package br.com.cepep.formacaojava.sistemabancario.model;

import br.com.cepep.formacaojava.sistemabancario.exception.AgenciaNaoEncontradaException;
import br.com.cepep.formacaojava.sistemabancario.util.Repositorio;


/**
 * Classe que define a entidade Banco
 * 
 * @author Aristenio Monteiro Filho 
 *
 */
public class Banco {
	
	private String nome;
	private Repositorio<Agencia> repositorio = new Repositorio<Agencia>();
	
	/**
	 * Construtor da entidade Banco, possui o parâmetro @String nome para obrigar que esta entidade sempre seja instaciada 
	 * com a propriedade nome preenchida
	 * @param nome Parametro que será setado na propriedade nome desta entidade 
	 */
	public Banco(String nome) {
		this.nome = nome;
		Agencia[] criarAgencias = Agencia.criarAgencias();
		for (Agencia agencia : criarAgencias) {
			repositorio.adicionaObjeto(agencia);
		}
	}

	/**
	 * Método que consulta uma dentre as agencias pertencentes ao banco
	 * @param agencia Numero da agencia a ser consultada
	 * @return Retorna a entidade agencia referente ao numero da agencia informada da consulta
	 * @throws AgenciaNaoEncontradaException Exceção levantada caso a agencia consultada não seja encontrada neste banco
	 */
	public Agencia consultarAgencia(String agencia) throws AgenciaNaoEncontradaException{
		
		for (Agencia agenciaTmp : repositorio.retornarTodos()) {
			if(agenciaTmp !=null && agenciaTmp.getNumero().equals(agencia))
				return agenciaTmp;
		}
		
		throw new AgenciaNaoEncontradaException("Nenhuma agencia foi encontrada com o numero "+agencia+" no Banco "+this.nome);
		
	}

	public String getNome() {
		return nome;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getNome();
	}
	
	
}
