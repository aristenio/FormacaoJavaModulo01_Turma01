
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

	public ContaBancaria consultarConta(int numeroConta) {
		for (int i = 0; i < this.contas.length; i++) {
			if(this.contas[i] != null && this.contas[i].numeroConta == numeroConta){
				return this.contas[i];
			}
		}
		
		return null;
	}
}
