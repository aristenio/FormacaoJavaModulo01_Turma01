package br.com.cepep.formacaojava.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import br.com.cepep.formacaojava.sistemabancario.model.Cliente;
import br.com.cepep.formacaojava.sistemabancario.model.ContaBancaria;

public class Teste6 {
	public static void main(String[] args) {
		Map<String,Cliente> mapa = new HashMap<String,Cliente>();
		Cliente c1 = new Cliente();
		c1.setNome("Cliente");
		mapa.put("A", c1);
		
		mapa.containsKey("A");
		mapa.containsValue(c1);
		
		mapa.remove("A");
		
		ContaBancaria conta1 = new ContaBancaria(1123654, new Cliente());
		ContaBancaria conta2 = new ContaBancaria(2546656, new Cliente());
		
		Map<Integer, ContaBancaria> mapaContas = new HashMap<Integer, ContaBancaria>();
		mapaContas.put(conta1.getNumeroConta(), conta1);
		mapaContas.put(conta2.getNumeroConta(), conta2);
		ContaBancaria rec = mapaContas.get(1123654);
		
		Set<Entry<Integer,ContaBancaria>> entrySet = mapaContas.entrySet();
		for (Entry<Integer, ContaBancaria> entry : entrySet) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		
	}

}
