package utils;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class Validacion {

	public void soloNumero(JTextField texto) {
		texto.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if(!Character.isDigit(caracter)) {
					e.consume();
				}
			}
		});
	}
	
	public void soloLetras(JTextField texto) {
		texto.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if(Character.isDigit(caracter)) {
					e.consume();
				}
			}
		});
	}
	
	public void limitarCaracteres(JTextField texto,int longitud) {
		texto.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(texto.getText().length() > longitud) {
					e.consume();
				}
			}
		});
	}
}
