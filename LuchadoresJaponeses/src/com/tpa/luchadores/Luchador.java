package com.tpa.luchadores;

public class Luchador {
	private Double peso;
	private Double altura;
	
	public Luchador(Double peso, Double altura) {
		super();
		this.peso = peso;
		this.altura = altura;
	}
	
	
	public boolean domina( Luchador l ) {
		return this.peso.compareTo(l.peso) >= 0 && this.altura.compareTo(l.altura) == 0;
	}
}
