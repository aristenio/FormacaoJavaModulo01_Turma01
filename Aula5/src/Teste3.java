
public class Teste3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ContaBancaria c1 = new ContaBancaria(100,null);
		c1.atualiza(2);
		System.out.println(c1.saldo);
		
		ContaBancaria c2 = new ContaPoupanca(100,null);
		c2.atualiza(2);
		System.out.println(c2.saldo);

		ContaBancaria c3 = new ContaCorrente(100,null);
		c3.deposita(100);
		c3.atualiza(2);
		System.out.println(c3.saldo);
	}

}
