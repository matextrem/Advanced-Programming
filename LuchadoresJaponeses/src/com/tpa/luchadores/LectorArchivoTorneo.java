package com.tpa.luchadores;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;



public class LectorArchivoTorneo {
	private String path;
	
	public LectorArchivoTorneo(String path) {
		super();
		this.path = path;
	}

	public void Leer() throws FileNotFoundException {
		Scanner sc = new Scanner(new File(path));
		sc.useLocale(Locale.ENGLISH);
		double[] vec = new double[sc.nextInt()];
		
		for (int i = 0; i < vec.length; i++) {
			vec[i] = sc.nextDouble();
			//operar
		}
		sc.close();
	}

}
