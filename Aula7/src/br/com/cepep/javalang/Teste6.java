package br.com.cepep.javalang;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Teste6 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer(); 
		
		try {
			InputStream is = new FileInputStream("C://arquivo.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			String b = br.readLine();
			
			while(b != null){
				sb.append(b);
				sb.append(" ");
				b = br.readLine();
			}
			
			System.out.println(sb.toString());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
