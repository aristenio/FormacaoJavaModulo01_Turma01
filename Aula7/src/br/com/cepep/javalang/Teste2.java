package br.com.cepep.javalang;

import br.com.cepep.formacaojava.sistemabancario.model.Cliente;
import br.com.cepep.formacaojava.sistemabancario.model.ContaBancaria;

public class Teste2 {
	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		ContaBancaria contaBancaria = new ContaBancaria(132456, cliente);
		ContaBancaria contaBancaria2 = new ContaBancaria(132456, cliente);
		
		System.out.println(contaBancaria);
		System.out.println(contaBancaria.hashCode());
		
		System.out.println(contaBancaria.equals(contaBancaria2));
		
	}
}
