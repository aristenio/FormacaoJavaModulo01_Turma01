
public class ContaBancaria {
	
	int numeroConta;
	Cliente cliente;
	int saldo;
	int limite;
	
	public void deposita(int valor){
		saldo += valor;
	}
	
	public boolean sacar(int valor){
		
		if(saldo > valor){
			saldo -= valor;
			return true;
		}else{
			return false;
		}
	}
	
	public String retornaInfoConta(){
		String retorno;
		
		retorno="Num. conta = "+numeroConta+"\n";
		retorno+="Nome. correntista = "+this.cliente.nome+"\n";
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

}
