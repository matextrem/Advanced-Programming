package com.tpa.luchadores;


public class Torneo {
	
	private Luchador[] luchadores; 
	
	public Torneo(Luchador[] luchadores) {
		this.luchadores = luchadores;
		
	}
	
	public int[] resolver(){
		int [] luchadoresDomina = new int[this.luchadores.length]; 
		for (int i = 0; i < this.luchadores.length; i++) {
			for (int j = i +1; j < this.luchadores.length; j++) {
				if(this.luchadores[i].domina(luchadores[j])) {
					luchadoresDomina[j]++;
				}
			}
		}
		
		return luchadoresDomina;
	
	}

}
