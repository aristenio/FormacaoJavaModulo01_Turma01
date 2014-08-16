package br.com.cepep.formacaojava.tratamentoerros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import br.com.cepep.formacaojava.sistemabancario.model.ContaPoupanca;

public class TesteErro3 {
	
	public static void main(String[] args) {

		try {
			
			int i = 5571;
//			i = i/0;
			System.out.println("resultado: " +i);
			
			ContaPoupanca c = null;
//			System.out.println(c.consultaSaldo());
			
			FileInputStream fi = new FileInputStream(new File("C:/arquivo.txt"));

		} catch (ArithmeticException e) {
			System.err.println("Falha matematica "+e);
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.err.println("Obejto nulo "+e);
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			try {
				FileInputStream fi = new FileInputStream(new File("C:/arquivo2.txt"));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
	}

}
