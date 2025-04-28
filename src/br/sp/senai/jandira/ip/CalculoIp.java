package br.sp.senai.jandira.ip;

import java.util.Scanner;

public class CalculoIp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String calcularClasseIp;
		
		Scanner scanner = new Scanner(System.in);
		
	    System.out.print("Digite o IP com CIDR (ex: 192.168.0.0/24): ");
	    String ip = scanner.nextLine();
		
	    String classe = calcularClasseIp;
	    
	    if (classe != null); {
	    	System.out.println("A classe do Ip " + ip + "é: " + classe);
	    } else {
	    	System.out.println("IP inválido");
	    }
	    	
	}
}
