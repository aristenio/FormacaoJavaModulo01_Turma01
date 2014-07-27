import java.util.Scanner;


public class RelatioMensalFuncoes {

	/**
	 * @param Programa para testar a utilização de métodos
	 */
	
	static String[] meses = new String[]{"JAN","FEV","MAR","ABR","MAI","JUN"};
	static int[] faturamentos = new int[]{1000,2000,5000,8000,2000,10000};
	
	public static void main(String[] args) {
		System.out.println(escreveCabecalho());
		String mes = recebeMes();
		String relatorioMensal = retornarRelatorioMensal(mes);
		System.out.println(relatorioMensal);
	}

	private static String retornarRelatorioMensal(String mes) {
		for (int i = 0; i < meses.length; i++) {
			if(mes.equals(meses[i])){
				return "No mês de "+mes+" a empresa faturou "+faturamentos[i];
			}
		}
		
		return "Sem faturamento para esse mês";
	}

	private static String recebeMes() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	private static String escreveCabecalho() {
		return "Cabecalho do mes";
	}
}
