

public class Banco {
	
	private String nome;
	private Agencia[] agencias = new Agencia[5];
	
	public Banco(String nome) {
		this.nome = nome;
		this.agencias = Agencia.criarAgencias();
	}

	public Agencia consultarAgencia(String agencia) {
		
		for (Agencia agenciaTmp : agencias) {
			if(agenciaTmp.getNumero().equals(agencia))
				return agenciaTmp;
		}
		
		return null;
	}

	public String getNome() {
		return nome;
	}
	
}
