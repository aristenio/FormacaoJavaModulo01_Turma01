package br.com.cepep.formacaojava.sistemabancario.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import br.com.cepep.formacaojava.sistemabancario.model.Cliente;
import br.com.cepep.formacaojava.sistemabancario.model.ContaBancaria;

public class Repositorio {

	private Object[] objetos;
	private int posicao = 0;

	public Repositorio(int quantidade) {
		this(quantidade, null);
	}

	public Repositorio(int quantidade, String nomeArquivo) {
		objetos = new Object[quantidade];
		
		if(nomeArquivo != null)
			carregarDados(nomeArquivo);
	}

	public void adicionaObjeto(Object object) {
		this.objetos[posicao] = object;
		posicao++;
	}

	public Object pegaObjeto(int posicao) {
		return this.objetos[posicao];
	}
	
	public Object[] retornarTodos(){
		return objetos;
	}
	
	public int retornaTamanho(){
		return objetos.length;
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
				this.adicionaObjeto(contaBancaria);
				linha = br.readLine();
			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


}
