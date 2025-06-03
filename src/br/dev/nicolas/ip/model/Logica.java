package br.dev.nicolas.ip.model;

import java.util.ArrayList;
import java.util.List;

public class Logica {

	private int primeiroOcteto;
	private int segundoOcteto;
	private int terceiroOcteto;
	private int quartoOcteto;
	private static int cidr;
	private int network;

	public void setOctetos(int primeiroOcteto, int segundoOcteto, int terceiroOcteto, int quartoOcteto) {
		this.primeiroOcteto = primeiroOcteto;
		this.segundoOcteto = segundoOcteto;
		this.terceiroOcteto = terceiroOcteto;
		this.quartoOcteto = quartoOcteto;
	}

	public void setCidr(int cidr) {
		this.cidr = cidr;
	}

	public String getIp() {
		return primeiroOcteto + "." + segundoOcteto + "." + terceiroOcteto + "." + quartoOcteto;
	}

	public String getClasseIp() {
		if (primeiroOcteto >= 0 && primeiroOcteto <= 127) {
			return "CLASSE A";
		} else if (primeiroOcteto >= 128 && primeiroOcteto <= 191) {
			return "CLASSE B";
		} else if (primeiroOcteto >= 192 && primeiroOcteto <= 223) {
			return "CLASSE C";
		} else {
			return "Valor inserido maior que 223!";
		}
	}

	public static String getMascaraDecimal(String classe) {
	    int[] octetos = new int[4];
	    int bitsRestantes = cidr;

	    for (int i = 0; i < 4; i++) {
	        if (bitsRestantes >= 8) {
	            octetos[i] = 255;
	            bitsRestantes -= 8;
	        } else if (bitsRestantes > 0) {
	            octetos[i] = (int) (256 - Math.pow(2, 8 - bitsRestantes));
	            bitsRestantes = 0;
	        } else {
	            octetos[i] = 0;
	        }
	    }

	    return octetos[0] + "." + octetos[1] + "." + octetos[2] + "." + octetos[3];
	}


	public static String getMascaraBinaria(String classe) {
	    StringBuilder mascaraBinaria = new StringBuilder();

	    for (int i = 0; i < 32; i++) {
	        if (i < cidr) {
	            mascaraBinaria.append('1');
	        } else {
	            mascaraBinaria.append('0');
	        }

	        if ((i + 1) % 8 == 0 && i < 31) {
	            mascaraBinaria.append('.');
	        }
	    }

	    return mascaraBinaria.toString();
	}


	public int getNumeroIpsDisponiveis() {
		if (cidr >= 32) {
			return 1;
		} else {
			return (int) Math.pow(2, 32 - cidr);
		}
	}

	public List<String> getSubRedes() {
	    List<String> subredes = new ArrayList<>();

	    // Converte o IP para um número de 32 bits
	    long ipBase = ((long) primeiroOcteto << 24) | ((long) segundoOcteto << 16) | ((long) terceiroOcteto << 8) | (long) quartoOcteto;

	    int totalIpsPorSubrede = (int) Math.pow(2, 32 - cidr);
	    int maxSubredes = Math.max(1, (int) ((Math.pow(2, cidr - getPrefixoPadrao(getClasseIp())))));

	    for (int i = 0; i < maxSubredes; i++) {
	        long subredeIp = ipBase + (long) i * totalIpsPorSubrede;

	        long broadcastIp = subredeIp + totalIpsPorSubrede - 1;
	        long primeiroValido = totalIpsPorSubrede > 2 ? subredeIp + 1 : subredeIp;
	        long ultimoValido = totalIpsPorSubrede > 2 ? broadcastIp - 1 : broadcastIp;

	        subredes.add(
	            "Sub-rede: " + formatarIp(subredeIp) + "/" + cidr + "\n" +
	            "  Primeiro IP válido: " + formatarIp(primeiroValido) + "\n" +
	            "  Último IP válido:   " + formatarIp(ultimoValido) + "\n" +
	            "  Broadcast:          " + formatarIp(broadcastIp) + "\n"
	        );
	    }

	    return subredes;
	}
	
	public int getNumeroDeSubRedes() {
	    int prefixoOriginal = getPrefixoPadrao(getClasseIp());
	    
	    if (cidr <= prefixoOriginal) {
	        return 1; // Sem sub-redes, é a rede original
	    }

	    return (int) Math.pow(2, cidr - prefixoOriginal);
	}


	private String formatarIp(long ip) {
	    return ((ip >> 24) & 0xFF) + "." +
	           ((ip >> 16) & 0xFF) + "." +
	           ((ip >> 8) & 0xFF) + "." +
	           (ip & 0xFF);
	}

	private int getPrefixoPadrao(String classe) {
	    switch (classe) {
	        case "CLASSE A": return 8;
	        case "CLASSE B": return 16;
	        case "CLASSE C": return 24;
	        default: return cidr;
	    }
	}




}
