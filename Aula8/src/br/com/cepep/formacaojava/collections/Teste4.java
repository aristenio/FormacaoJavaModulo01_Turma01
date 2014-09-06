package br.com.cepep.formacaojava.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import br.com.cepep.formacaojava.sistemabancario.model.Cliente;
import br.com.cepep.formacaojava.sistemabancario.model.ContaBancaria;

public class Teste4 {

	public static void main(String[] args) {
		
		Set<String> cargos2 = new HashSet<String>();
		System.out.println(cargos2.add("Gerente"));
		System.out.println(cargos2.add("Diretor"));
		System.out.println(cargos2.add("Vendedor"));
		System.out.println(cargos2.add("Secretária"));
		System.out.println(cargos2.add("Diretor"));
		System.out.println("Conjunto sem repetições /n");
		System.out.println(cargos2);

		Set<String> cargos = new TreeSet<String>();
		cargos.add("Gerente");
		cargos.add("Diretor");
		cargos.add("Vendedor");
		cargos.add("Secretária");
		cargos.add("Diretor");
		System.out.println("Ordenada /n");
		System.out.println(cargos);

		Set<String> cargos3 = new LinkedHashSet<String>();
		cargos3.add("Gerente");
		cargos3.add("Diretor");
		cargos3.add("Vendedor");
		cargos3.add("Secretária");
		cargos3.add("Diretor");
		System.out.println("Ligadas /n");
		System.out.println(cargos3);
		
		ContaBancaria c1 = new ContaBancaria(1, new Cliente());
		c1.deposita(20);
		ContaBancaria c2 = new ContaBancaria(2, new Cliente());
		c2.deposita(10);
		
		List<ContaBancaria> contas = new ArrayList<ContaBancaria>();
		contas.add(c1);
		contas.add(c2);
		System.out.println("Comparação com comparable");
		System.out.println(contas);
		
		System.out.println("Comparação com comparator");
		Comparator comp = new ContaBancariaComparator();
		Collections.sort(contas, comp);
		
		System.out.println(contas);
		
		ContaBancaria c3 = new ContaBancaria(1, new Cliente());
		c1.deposita(20);
		ContaBancaria c4 = new ContaBancaria(1, new Cliente());
		c2.deposita(10);
		
		Set<ContaBancaria> contas2 = new HashSet<ContaBancaria>();
		System.out.println(contas2.add(c3));
		System.out.println(contas2.add(c4));
		
		System.out.println(contas2.size());
	}

}
