package br.sp.senai.jandira.ip;

public class Mascara {
	
	private static int cidr;
	
	//Máscara decimal
	public static String gerarMascaraDecimal() {
		int mascaraBinario = (int) (0xFFFFFFFF << (32 - cidr)); 
		
		int octeto1 = (mascaraBinario >> 24) & 0xFF;
		int octeto2 = (mascaraBinario >> 16) & 0xFF;
		int octeto3 = (mascaraBinario >> 8) & 0xFF;
		int octeto4 = mascaraBinario & 0xFF;
		
		return octeto1 + "." + octeto2 + "." + octeto3 + "." + octeto4;
	}
	
	//Máscara binária
	public static String gerarMascaraBinaria() {
		System.out.println("Máscara binária: ");
	    for (int i = 3; i >= 0; i--) {
	        System.out.print(String.format("%8s", Integer.toBinaryString((mascaraBinario >> (i * 8)) & 0xFF)).replace(' ', '0') + " ");
	    }
	    System.out.println();
	}

	public int getCidr() {
		return cidr;
	}

	public void setCidr() {
		this.cidr = cidr;
	}


}
