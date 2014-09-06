package br.com.cepep.formacaojava.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Teste5 {
	public static void main(String[] args) {
		List<String> lista = new ArrayList<String>();
		lista.add("dsffsd");
		lista.add("fgfh");
		lista.add("cvg");
		lista.add("dffd");
		lista.add("wsdsdf");
		
		for (String string : lista) {
			System.out.println(string);
		}
		
		Iterator<String> iterator = lista.iterator();
		while(iterator.hasNext()){
			String str = iterator.next();
			System.out.println(str);
		}
		
	}
}
