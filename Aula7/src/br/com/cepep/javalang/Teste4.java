package br.com.cepep.javalang;

import br.com.cepep.formacaojava.sistemabancario.model.Banco;
import br.com.cepep.formacaojava.sistemabancario.model.Cliente;
import br.com.cepep.formacaojava.sistemabancario.util.Repositorio;

public class Teste4 {
	public static void main(String[] args) {
		
		Object object = new Cliente();
		
		Repositorio repositorio = new Repositorio(2);
		
		Cliente cliente = (Cliente)object;
		cliente.setNome("teste");
		repositorio.adicionaObjeto(cliente);

		Banco banco = new Banco("teste");
		repositorio.adicionaObjeto(banco);
		
		Cliente pegaObjeto = (Cliente)repositorio.pegaObjeto(0);
		System.out.println(pegaObjeto.getNome());
		
		Cliente cliente2 = null;
		Banco banco2 = null;
		
		Object objeto2 = repositorio.pegaObjeto(1);
		
		if(objeto2 instanceof Cliente)
			cliente2 = (Cliente) objeto2;
		else if(objeto2 instanceof Banco)
			banco2 = (Banco) objeto2;
		
		try {
			cliente2 = (Cliente) objeto2;
		} catch (ClassCastException e) {
			banco2 = (Banco) objeto2;
		}
		
		System.out.println(cliente2);
		System.out.println(banco2);
		
	}
}
