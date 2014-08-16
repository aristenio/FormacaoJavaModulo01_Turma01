package br.com.cepep.formacaojava.heranca;


public class Teste2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Funcionario f1 = new Vendedor();
		f1.setNome("joar");
		f1.setSobrenome("sila");
		f1.setMatricula("12345");
		
		System.out.println(f1.quemEhVoce());
		
		Vendedor vendedor = new Vendedor();
		vendedor.setMatricula("5464");
		vendedor.setNome("vend");
		vendedor.setSobrenome("xavir");
		vendedor.setComissao(1);
		System.out.println(vendedor.quemEhVoce());
		
		Gerente g1 = new Gerente();
		g1.setMatricula("02");
		g1.setNome("ge");
		g1.setSobrenome("sd");
		g1.setCodigoCofre(9846546);
		System.out.println(g1.quemEhVoce());
		
		Diretor diretor = new Diretor();
		diretor.setNome("D1");
		diretor.setSobrenome("sjh");
		diretor.setCodigoCofre(54654);
		System.out.println(diretor.quemEhVoce());
		System.out.println(diretor.getCodigoCofre());
		
		
		Funcionario f2 = new Vendedor();
		f2.setNome("f2");
		
		Vendedor v1 = (Vendedor) f2;
		v1.setComissao(1);
		
		
	}

}
