package com.tpa.luchadores;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EscritorArchivoTorneo {
	
	public void escribirTorneo(String path) throws IOException {
		PrintWriter salida = new PrintWriter(new FileWriter(path));
		int z = 50;
		String s = "dni";
		salida.println(" " + z);
		salida.close();
	}

}
