package br.com.cepep.formacaojava.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import br.com.cepep.formacaojava.sistemabancario.model.Cliente;

public class Teste1 {
	public static void main(String[] args) {
		List lista2 = new LinkedList();

		List lista = new ArrayList();
		lista.add("String");
		lista.add(10);
		lista.add(100L);
		lista.add(10f);
		lista.add('A');
		lista.add("String");
		lista.add("String");
		
		System.out.println(lista.size());
		
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}
		
		Object[] arr = lista.toArray();
		
		String[] strs = new String[]{"a","b","c"};
		List lista3 = Arrays.asList(strs);
		
		Cliente c1 = new Cliente();
		Cliente c2 = new Cliente();
		Cliente c3 = new Cliente();
		Cliente c4 = new Cliente();
		
		List listaClientes = new ArrayList();
		listaClientes.add(c1);
		listaClientes.add(c2);
		listaClientes.add(c3);
		listaClientes.add(c4);
		
		for (Object object : listaClientes) {
			System.out.println(((Cliente)object).getNome());
		}
		
		for (int i = 0; i < listaClientes.size(); i++) {
			System.out.println(((Cliente)listaClientes.get(i)).getNome());
		}
	}

}
