package br.com.cepep.formacaojava.tratamentoerros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TesteErro1 {
	
	public static void main(String[] args) {
		try {
			metodo();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void metodo() throws FileNotFoundException {
		try {
			FileInputStream fi = new FileInputStream(new File("C:/arquivo.txt"));
		} catch (ArithmeticException e) {
			System.err.println("Falha matematica "+e);
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.err.println("Obejto nulo "+e);
			e.printStackTrace();
		}
	}

}
