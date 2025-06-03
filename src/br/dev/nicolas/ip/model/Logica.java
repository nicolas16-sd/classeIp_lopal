package br.dev.nicolas.ip.model;

import java.util.ArrayList;
import java.util.List;

public class Logica {

	private int primeiroOcteto;
	private int segundoOcteto;
	private int terceiroOcteto;
	private int quartoOcteto;
	private int cidr;
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
		switch (classe) {
		case "CLASSE A":
			return "255.0.0.0";
		case "CLASSE B":
			return "255.255.0.0";
		case "CLASSE C":
			return "255.255.255.0";
		default:
			return "Fora do intervalo!";
		}
	}

	public static String getMascaraBinaria(String classe) {
		switch (classe) {
		case "CLASSE A":
			return "11111111.00000000.00000000.00000000";
		case "CLASSE B":
			return "11111111.11111111.00000000.00000000";
		case "CLASSE C":
			return "11111111.11111111.11111111.00000000";
		default:
			return "Fora do intervalo!";
		}
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
