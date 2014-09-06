package br.com.cepep.formacaojava.sistemabancario.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import br.com.cepep.formacaojava.sistemabancario.model.Cliente;
import br.com.cepep.formacaojava.sistemabancario.model.ContaBancaria;

public class Repositorio<E> {

	private List<E> objetos;

	public Repositorio() {
	}

	public Repositorio( String nomeArquivo) {
		objetos = new ArrayList<E>();
		
		if(nomeArquivo != null)
			carregarDados(nomeArquivo);
	}

	public void adicionaObjeto(E object) {
		objetos.add(object);
	}

	public E pegaObjeto(int posicao) {
		return objetos.get(posicao);
	}
	
	public List<E> retornarTodos(){
		return objetos;
	}
	
	public int retornaTamanho(){
		return objetos.size();
	}
	
	private void carregarDados(String nomeArquivo) {
		try {
			InputStream is = new FileInputStream(nomeArquivo);
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String linha = br.readLine();
			
			while(linha != null){
				String[] arr = linha.split(";;");
				Cliente cliente = new Cliente();
				cliente.setNome(arr[1]);
				ContaBancaria contaBancaria = new ContaBancaria(Integer.parseInt(arr[0].trim()), cliente);
				this.adicionaObjeto((E) contaBancaria);
				linha = br.readLine();
			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void preencher(List lista){
		this.objetos = lista;
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		this.objetos = null;
	}
}
