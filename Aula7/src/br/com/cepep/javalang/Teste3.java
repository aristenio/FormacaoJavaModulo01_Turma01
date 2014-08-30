package br.com.cepep.javalang;

public class Teste3 {
	public static void main(String[] args) {
		String str1 = "teste";
		String str2 = "teste";
		
		String str11 = new String("teste");
		String str22 = new String("teste");
		
		System.out.println(str1 == str2);
		
		System.out.println(str11.equals(str22));
		
		String str3 = "java é show";
		String[] split = str3.split(" ");
		for (String string : split) {
			System.out.println(string);
		}
		
		System.out.println(str3.charAt(5));
		System.out.println(str3.substring(5));
		System.out.println(str3.substring(5,8));
		
		System.out.println(str3.toUpperCase().replace("A", "e"));
		System.out.println(str3);
		System.out.println(str3.replace(" ", ".."));
		str3 = str3.replace(" ", "..");
		System.out.println(str3);
		
		if(str3 != null && !str3.equals(""))
			str3 = "Nova string";

		if(str3 != null && !str3.isEmpty())
			str3 = "Nova string";
		
		int i = 3;
		String s = i + "";
		String s2 = String.valueOf(i);
		
		StringBuffer sb = new StringBuffer("texto");
		sb.append("test02");
		sb.append("test02sdfds");
		sb.append("test02sdfdssfddsf");
	}
}
