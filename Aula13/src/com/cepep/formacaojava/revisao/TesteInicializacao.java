package com.cepep.formacaojava.revisao;

public class TesteInicializacao {
	String a = "abc";
	static String b = "cde";
	
	public TesteInicializacao(){
		System.out.println("metodo construtor 1");
	}
	
	public TesteInicializacao(String str){
		System.out.println("metodo construtor 2");
	}
	
	{
		System.out.println("classe inicializada");
	}
	
	static{
		System.out.println("inicializacao estatica");
	}
	
	public static void main(String[] args) {
//		new TesteInicializacao("sdfs");
		System.out.println(TesteInicializacao.b);
	}
}
