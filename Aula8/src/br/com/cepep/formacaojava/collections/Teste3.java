package br.com.cepep.formacaojava.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.cepep.formacaojava.sistemabancario.model.Cliente;

public class Teste3 {
	public static void main(String[] args) {
		List<String> strs = new ArrayList<String>();
		strs.add("Sérgio");
		strs.add("Ricardo");
		strs.add("Aeliton");
		strs.add("Raimundo");
		
		System.out.println(strs);
		
		Collections.sort(strs);
		
		System.out.println(strs);
		
		System.out.println(Collections.binarySearch(strs, "Ricardo"));
		
		String ricardo = strs.get(Collections.binarySearch(strs, "Ricardo"));
		
		System.out.println(ricardo);
		
		Cliente c1 = new Cliente();
		c1.setNome("Francisco");
		Cliente c2 = new Cliente();
		c2.setNome("Aristenio");
		Cliente c3 = new Cliente();
		c3.setNome("Jose");
		Cliente c4 = new Cliente();
		c4.setNome("Antonio");
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(c1);
		clientes.add(c2);
		clientes.add(c3);
		clientes.add(c4);
		
		System.out.println("Não ordenado \n");
		for (Cliente cliente : clientes) {
			System.out.println(cliente.getNome());
		}

		Collections.sort(clientes);
		
		System.out.println("Ordenado \n");
		for (Cliente cliente : clientes) {
			System.out.println(cliente.getNome());
		}

		System.out.println("Inverso \n");
		
		Collections.reverse(clientes);
		for (Cliente cliente : clientes) {
			System.out.println(cliente.getNome());
		}
		
		System.out.println("Menor \n");
		Cliente min = Collections.min(clientes);
		System.out.println(min);

		System.out.println("Maior \n");
		Cliente max = Collections.max(clientes);
		System.out.println(max);
		
	}

}
