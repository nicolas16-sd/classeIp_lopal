package br.sp.senai.jandira.ip;

public class ClasseIp {

	private static String ipComMascara;
	private int primeiroOcteto;
	
	public static String calcularClasseIp() {
		try {
			String ip = ipComMascara.split("/")[0];
			
			String[] octetos = ip.split("\\.");
			
			int primeiroOcteto = Integer.parseInt(octetos[0]);
			
			if (primeiroOcteto >= 1 && primeiroOcteto <= 126) {
				return "Classe A";	
			} else if (primeiroOcteto >= 128 && primeiroOcteto <= 191) {
				return "Classe B";
			} else if (primeiroOcteto >= 192 && primeiroOcteto <= 223) {
				return "Classe C";
			} else if (primeiroOcteto >= 224 && primeiroOcteto <= 239) {
				return "Classe D (Multicast)";
			} else if (primeiroOcteto >= 240 && primeiroOcteto <= 254){
				return "Classe E (Experimental)";
			} else {
				return "IP inválido ou reservado";
			}
		} catch (Exception E) {
			return "O ip que você digitou está inválido";
		}
	}



	public String getIpComMascara() {
		return ipComMascara;
	}

	public void setIpComMascara(String ipComMascara) {
		this.ipComMascara = ipComMascara;
	}
}
