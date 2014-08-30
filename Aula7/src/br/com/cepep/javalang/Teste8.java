package br.com.cepep.javalang;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import br.com.cepep.formacaojava.sistemabancario.model.Agencia;

public class Teste8 {
	public static void main(String[] args) {
		BufferedWriter bf = null;
		try {
			OutputStream os = new FileOutputStream("D://Aristenio/dados/agencias");
			OutputStreamWriter osw  = new OutputStreamWriter(os);
			bf = new BufferedWriter(osw);
			
			Agencia[] criarAgencias = Agencia.criarAgencias();
			for (Agencia agencia : criarAgencias) {
				if(agencia != null)
					bf.write(agencia.getNumero());
					bf.newLine();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(bf!=null)
				try {
					bf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
	}

}
