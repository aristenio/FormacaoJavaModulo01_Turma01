
public class ContaBancaria {
	
	private int numeroConta;
	private Cliente cliente;
	protected int saldo;
	private int limite;
	
	public ContaBancaria(int numeroConta, Cliente cliente) {
		this.numeroConta = numeroConta;
		this.cliente = cliente;
		this.saldo = 0;
		this.limite = 1000;
	}

	public void deposita(int valor){
		saldo += valor;
	}
	
	public boolean sacar(int valor){
		
		if((saldo + limite) >= valor){
			saldo -= valor;
			return true;
		}else{
			return false;
		}
	}
	
	public String retornaInfoConta(){
		String retorno;
		
		retorno="Num. conta = "+numeroConta+"\n";
		retorno+="Nome. correntista = "+this.cliente.getNome()+"\n";
		retorno+="Saldo = "+saldo+"\n";
		retorno+="Limite = "+limite+"\n";
		
		return retorno;
	}
	
	public boolean transfere(ContaBancaria conta, int valor){
		if(this.sacar(valor)){
			conta.deposita(valor);
			return true;
		}else
			return false;
	}
	
	public void atualiza(double taxa){
		this.saldo = (int) (this.saldo * taxa);
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public Cliente getCliente() {
		return cliente;
	}
}
