package br.sp.senai.jandira.ip;

import java.util.Scanner;

public class CalculoIp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
	    System.out.print("Digite o IP com CIDR (ex: 192.168.0.0/24): ");
	    String ip = scanner.nextLine();
		
	    String classe = ClasseIp.calcularClasseIp();
	    
	    System.out.println("A Classe do Ip é: " + classe);
	    
	    int cidr = Integer.parseInt(ip.split("/")[1]);
	    Mascara decimal = new Mascara();
	    String mascaraDecimal = Mascara.gerarMascaraDecimal();
	    System.out.println("Mascara decimal: " + mascaraDecimal);
	    
	    scanner.close();
}
}
