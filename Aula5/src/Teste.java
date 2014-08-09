
public class Teste {
	public static void main(String[] args) {

		System.out.println(Cliente.contador);
		
		Cliente c1 = new Cliente();
		c1.setNome("Joao");
		
		System.out.println(Cliente.contador);
		
		Cliente c2 = new Cliente();
		c2.setNome("Jose");
		
		System.out.println(Cliente.contador);
		
	}
}
