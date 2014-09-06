package br.com.cepep.formacaojava.collections;

import java.util.ArrayList;
import java.util.List;

import br.com.cepep.formacaojava.sistemabancario.model.Cliente;
import br.com.cepep.formacaojava.sistemabancario.model.ClientePJ;

public class Teste2 {

	public static void main(String[] args) {
		List clientes1 = new ArrayList();//Java4
		List<Cliente> clientes2 = new ArrayList<Cliente>();//Java5
		//		List<Cliente> clientes3 = new ArrayList<>();//Java7
		Cliente c1 = new Cliente();
		ClientePJ cpj = new ClientePJ();
		clientes2.add(c1);
		clientes2.add(cpj);
		
		for (Cliente cliente : clientes2) {
			System.out.println(cliente.getNome());
		}
		
		List<Identificavel> identificavels = new ArrayList<Identificavel>();
		
		Indet i = new Indet();
		
		identificavels.add(i);
	}

}
