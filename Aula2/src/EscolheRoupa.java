
public class EscolheRoupa {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double randomCamisa = Math.random();
		System.out.println(randomCamisa);
		
		double verificaCamisa = 0.5;
		double verificaCalca = 0.75;
		
		if(randomCamisa < verificaCamisa){
			System.out.println("Camisa branca");
		}else{
			System.out.println("Camisa preta");
		}

		double randomCalca = Math.random();

		if(randomCalca < verificaCalca){
			System.out.println("Jeans");
		}else if(randomCalca > 0.9){
			System.out.println("Bermuda Jeans");
		}else if(randomCalca > 0.8){
			System.out.println("Bermuda Cargo");
		}else if(randomCalca > 0.6){
			System.out.println("Bermuda Surf");
		}else{
			System.out.println("Calção");
		}
		
	}

}
