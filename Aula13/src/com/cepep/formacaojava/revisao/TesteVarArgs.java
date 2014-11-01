package com.cepep.formacaojava.revisao;

public class TesteVarArgs {
	public static void main(String[] args) {
		escreva("a");
		escreva("a","b");
		escreva("a","b","c");
		
		String formata = String.format("Uma string com parametro: %d", 1);
		System.out.println(formata);
		
		String formata2 = String.format("Uma string com parametro: %d e outra string %s", 1,"outra str");
		System.out.println(formata2);
	}

	private static void escreva(String... string) {
		for (String str : string) {
			System.out.println(str);
		}
	}
}
