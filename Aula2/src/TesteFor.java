
public class TesteFor {

	public static void main(String[] args) {
		
		int cont = 0;
		
		while(cont<5) {
			System.out.println(cont);
			cont++;
		}
		
		for (int i = 0,j=0; (i < 5 || i> j); i++,j++) {
			System.out.println(i);
		}
		
		for (;true;) {
			
		}
		
	}

}
