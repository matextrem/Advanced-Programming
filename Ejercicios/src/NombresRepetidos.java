import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class NombresRepetidos {
	private String[] nombres;
	private String path;
	private int podio;
	private int cantidad;
	private HashMap<String, Integer> nombreCantidad = new HashMap<String, Integer>();
	private TreeMap<String, Integer> nombresPodio = new TreeMap<String, Integer>();  
	
	public NombresRepetidos(String path) {
		this.path = path;
		this.leerArchivo();
		
	}
	
	public void leerArchivo() {
		try {
			Scanner sc = new Scanner(new File(this.path));
			sc.useLocale(Locale.ENGLISH);
			int i = 0;
			this.cantidad = sc.nextInt();
			this.podio = sc.nextInt();
			this.nombres = new String[this.cantidad];
			while(sc.hasNext()) {
				this.nombres[i] = sc.next();
				i++;
			}
			sc.close();
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void calcularNombres() {
		Map.Entry<String, Integer> temp = null;
		for(String nombre : this.nombres) {
			if(!this.nombreCantidad.containsKey(nombre))
				this.nombreCantidad.put(nombre, 1);
			else
				this.nombreCantidad.put(nombre, this.nombreCantidad.get(nombre) + 1);
		}
		
		for(int i = 0; i<this.podio; i++) {
			temp = this.calcularMaximo();
			this.nombresPodio.put(temp.getKey(), temp.getValue());
			this.nombreCantidad.remove(temp.getKey());
		}
		
	}
	
	public Map.Entry<String, Integer> calcularMaximo() {
		Map.Entry<String, Integer> max = null;
		for(Map.Entry<String, Integer> entry : this.nombreCantidad.entrySet()) {
			if(max == null || (entry.getValue().compareTo(max.getValue())) > 0 )
				max = entry;
		}
		return max;
	}
	
	public void escribirArchivo(String path) {
		PrintWriter salida;
		try {
			salida = new PrintWriter(new FileWriter(path));
			for(Map.Entry<String, Integer> nombre : this.nombresPodio.entrySet())
				salida.println(nombre.getKey() + " " + nombre.getValue());
			salida.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
