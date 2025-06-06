	package br.dev.nicolas.ip.gui;
	
	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;
	import java.util.List;
	
	import br.dev.nicolas.ip.model.*;
	
	public class Interface extends JFrame {
	
	    private JTextField[] octetos = new JTextField[4];
	    private JTextField campoCidr = new JTextField();
	    private JButton botaoCalcular = new JButton("Calcular");
	    private JTextArea resultadoArea = new JTextArea();
	    
	    public Interface() {
	        setTitle("Calculadora de IP");
	        setSize(400, 350);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLayout(null);
	
	        JLabel rotuloIp = new JLabel("Endereço IP:");
	        rotuloIp.setBounds(20, 20, 100, 25);
	        add(rotuloIp);
	
	        int x = 120;
	        for (int i = 0; i < 4; i++) {
	            octetos[i] = new JTextField();
	            octetos[i].setBounds(x, 20, 40, 25);
	            add(octetos[i]);
	            x += 45;
	            if (i < 3) {
	                JLabel ponto = new JLabel(".");
	                ponto.setBounds(x - 5, 20, 10, 25);
	                add(ponto);
	            }
	        }
	
	        JLabel rotuloCidr = new JLabel("CIDR:");
	        rotuloCidr.setBounds(20, 60, 100, 25);
	        add(rotuloCidr);
	
	        campoCidr.setBounds(120, 60, 50, 25);
	        add(campoCidr);
	
	        botaoCalcular.setBounds(200, 60, 120, 25);
	        add(botaoCalcular);
	
	        resultadoArea.setBounds(20, 100, 340, 180);
	        resultadoArea.setEditable(false);
	        add(resultadoArea);
	
	        // Evento do bot�o calcular
	        botaoCalcular.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                calcular();
	            }
	        });
	
	        setLocationRelativeTo(null); // Centraliza a janela
	        setVisible(true);
	    }
	
	    private void calcular() {
	        try {
	            int o1 = Integer.parseInt(octetos[0].getText());
	            int o2 = Integer.parseInt(octetos[1].getText());
	            int o3 = Integer.parseInt(octetos[2].getText());
	            int o4 = Integer.parseInt(octetos[3].getText());
	            int cidr = Integer.parseInt(campoCidr.getText());
	
	            Logica ip = new Logica();
	            ip.setOctetos(o1, o2, o3, o4);
	            ip.setCidr(cidr);
	
	            String classe = ip.getClasseIp();
	            String resultado = "IP: " + ip.getIp() + "\n";
	            resultado += "Classe: " + classe + "\n";
	            resultado += "Máscara Decimal: " + Logica.getMascaraDecimal(classe) + "\n";
	            resultado += "Máscara Binária: " + Logica.getMascaraBinaria(classe) + "\n";
	            resultado += "Número de IPs disponíveis: " + ip.getNumeroIpsDisponiveis() + "\n";
	            resultado += "Número de sub-redes: " + ip.getNumeroDeSubRedes() + "\n";
	            resultado += "\nSub-redes:\n";
	            for (String subrede : ip.getSubRedes()) {
	                resultado += subrede + "\n";
	            }
	
	
	            resultadoArea.setText(resultado);
	        } catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(this, "Digite apenas números v�lidos nos campos.", "Erro", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	
	}