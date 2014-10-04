package com.cepep.formacaojava.revisao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TesteContainArray {
	
	public static void main(String[] args) {
		String[] arrStr = new String[]{"AA","BB","CC","DD"};
		String stringBusca = "A";
		
		long tempoInicio = System.nanoTime();
		for (int i = 0; i < arrStr.length; i++) {
			if(arrStr.equals(stringBusca)){
				System.out.println(String.format("Encontrado no indice %d", i));
				break;
			}
		}
		long tempoFinal = System.nanoTime();
		System.out.println(String.format("Tempo gasto: %d",tempoFinal-tempoInicio));
		
		usandoList(arrStr, stringBusca);
		usandoSet(arrStr, stringBusca);
		usandoBinarySearch(arrStr, stringBusca);
	}
	
	private static void usandoList(String[] arr, String localizar){
		long tempoInicio = System.nanoTime();
		Arrays.asList(arr).contains(localizar);
		long tempoFinal = System.nanoTime();
		System.out.println(String.format("Tempo gasto: %d",tempoFinal-tempoInicio));
	}
	
	private static void usandoSet(String[] arr, String localizar){
		long tempoInicio = System.nanoTime();
		Set<String> setStr = new HashSet<String>(Arrays.asList(arr));
		setStr.contains(localizar);
		long tempoFinal = System.nanoTime();
		System.out.println(String.format("Tempo gasto: %d",tempoFinal-tempoInicio));
	}
	
	private static void usandoBinarySearch(String[] arr, String localizar){
		long tempoInicio = System.nanoTime();
		Arrays.binarySearch(arr, localizar);
		long tempoFinal = System.nanoTime();
		System.out.println(String.format("Tempo gasto: %d",tempoFinal-tempoInicio));
	}
}
