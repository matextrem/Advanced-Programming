import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Baldosas {
	private static final char ROJO = 'R';
	private static final char VERDE = 'V';
	private static final char AZUL = 'A';
	private char[] baldosas;
	private HashMap<Character, Integer> contador = new HashMap<Character, Integer>();
	private String path;
	private final int cantPorBaldosas;
	
	public Baldosas(String path) {
		this.path = path;
		contador.put(ROJO, 0);
		contador.put(VERDE, 0);
		contador.put(AZUL, 0);
		this.leerArchivo();
		this.cantPorBaldosas = this.baldosas.length / 3;
	}
	
	public void leerArchivo() {
		try {
			Scanner sc = new Scanner(new File(this.path));
			this.baldosas = sc.next().toCharArray();
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void pintarBaldosas() {
		int posicionYaPintada = 0;
		for(int i=0;i<this.baldosas.length;i++) {
			if(this.contador.containsKey(this.baldosas[i])) {
				this.contador.put(this.baldosas[i], this.contador.get(this.baldosas[i]) + 1);
				posicionYaPintada = i;
			}
		}
		this.dividirBaldosas(1, posicionYaPintada);
		this.dividirBaldosas(posicionYaPintada + 1,this.baldosas.length);

	}
	
	public void dividirBaldosas(int li,int lf) {
		for(int i = li;i<lf;i++) {
			actualizarBaldosas(VERDE,i);
			actualizarBaldosas(ROJO,i);
			actualizarBaldosas(AZUL,i);
		}
		this.pintarRestantes(0);
		this.pintarRestantes(this.baldosas.length -1);
	}
	
	public void actualizarBaldosas(char color, int pos) {
		if(this.baldosas[pos] != '*') return;
		if(this.baldosas[pos-1] != color && this.contador.get(color) < cantPorBaldosas) {
			this.baldosas[pos] = color;
			this.contador.put(color, this.contador.get(color) + 1);
		}
		
	}
	
	public void pintarRestantes(int pos) {
		char[] colores = {VERDE,ROJO,AZUL};
		for(char color : colores) {
			if(this.contador.get(color)< cantPorBaldosas) {
				if(pos == 0) {
					if(this.baldosas[pos+1] != color)
						this.baldosas[pos] = color;
				}else {
					if(this.baldosas[pos-1] != color)
						this.baldosas[pos] = color;
				}
				this.contador.put(color, this.contador.get(color) + 1);
			}
		}
	}
	
	public void escribirArchivo(String path) {
		PrintWriter salida;
		try {
			salida = new PrintWriter(new FileWriter(path));
			salida.println(String.copyValueOf(this.baldosas));
			salida.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
