package br.com.cepep.javalang;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import br.com.cepep.formacaojava.sistemabancario.model.Cliente;
import br.com.cepep.formacaojava.sistemabancario.model.ContaBancaria;
import br.com.cepep.formacaojava.sistemabancario.util.Repositorio;

public class Teste7 {
	public static void main(String[] args) {
		Repositorio repositorio = new Repositorio(4);
		try {
			InputStream is = new FileInputStream("C://arquivo2.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			String linha = br.readLine();
			
			while(linha != null){
				String[] arr = linha.split(";;");
				Cliente cliente = new Cliente();
				cliente.setNome(arr[1]);
				ContaBancaria contaBancaria = new ContaBancaria(Integer.parseInt(arr[0].trim()), cliente);
				repositorio.adicionaObjeto(contaBancaria);
				linha = br.readLine();
			}
		
			Object[] retornarTodos = repositorio.retornarTodos();
			for (Object object : retornarTodos) {
				System.out.println((object));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
