package com.cepep.formacaojava.revisao;

public class TestePassagemPorReferencia {
	public static void main(String[] args) {
		StringBuilder x = new StringBuilder("ab");
		alterar(x);
		System.out.println(x);
	}

	private static void alterar(StringBuilder x) {
		x.delete(0,2).append("cd");
	}
}
