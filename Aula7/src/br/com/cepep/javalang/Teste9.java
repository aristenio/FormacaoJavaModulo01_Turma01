package br.com.cepep.javalang;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Teste9 {
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			PrintStream ps = new PrintStream("C://arquivo.txt");
			while(scanner.hasNextLine()){
				ps.println(scanner.nextLine());
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
