package br.com.cepep.javalang;

import java.io.IOException;
import java.io.PrintStream;

public class Testes extends Object{
	
	public static void main(String[] args) {
		PrintStream saida = System.out;
		saida.println("Olá Turma");
		
		try {
			Runtime runtime = Runtime.getRuntime();
			runtime.exec("wget http://www.aqr.com/file.deb");
			runtime.exec("cd ~/");
			runtime.exec("cd files");
			runtime.exec("sudo ./install.sh");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
