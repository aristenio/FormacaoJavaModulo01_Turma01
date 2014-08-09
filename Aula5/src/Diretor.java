
public class Diretor extends Gerente {
	
	public int getCodigoCofre() {
		return 0;
	}

	public void setCodigoCofre(int codigoCofre) {
	}

	public String quemEhVoce(){
		return super.quemEhVoce() +" e Sou o Diretor";
	}
}
