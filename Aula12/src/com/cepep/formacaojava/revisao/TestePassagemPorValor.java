package com.cepep.formacaojava.revisao;

public class TestePassagemPorValor {
	
	public static void main(String[] args) {
		String x = new String("ab");
		alterar(x);
		System.out.println(x);
	}

	private static void alterar(String x) {
		x = "cd";
	}
}
