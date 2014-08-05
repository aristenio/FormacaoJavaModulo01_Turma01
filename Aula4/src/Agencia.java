
public class Agencia {
	String numero;
	ContaBancaria[] contas = new ContaBancaria[20];
	
	public void adicionarConta(ContaBancaria contaBancaria){
		for (int i = 0; i < contas.length; i++) {
			if(contas[i] == null){
				contas[i] = contaBancaria;
				break;
			}
		}
	}
}
