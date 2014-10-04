package com.cepep.formacaojava.revisao;


public class TesteHeranca {

		public static void main(String[] args) {
			Cachorro anita = new Boxer();
			anita.latir();
			
			Cachorro caramelo = new Caramelo();
			caramelo.latir();
			
			System.out.println(escrever("AAA"));
			System.out.println(escrever("AAA","BBBB"));
		}
		
		public static String escrever(String s){
			return s;
		}
		
		public static String escrever(int i){
			return i+"";
		}
		
		public static String escrever(String s1, String s2){
			return s1+s2;
		}
		
		public static int escrever(String s1, String s2, String s3){
			return 0;
		}

	}
	

