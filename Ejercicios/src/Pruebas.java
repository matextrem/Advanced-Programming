import java.util.Arrays;
import java.util.LinkedList;

public class Pruebas {
	
	 public int zapatos(int pilas, int[] orden){
	  		int totalMovs = 0;
	    	int cantidadPorFila = Arrays.stream(orden).sum() / pilas;
	    	for (int i : orden)
				totalMovs += Math.abs(cantidadPorFila - i);
	    	return totalMovs/2;
	}
	 
	// mezadas de granito.
	public int mesadas(int cant, int[][] dimensiones) {
		if(cant <= 0) return 0;
		int pilas  = 1;
		for(int i = 1;i < cant;i++) {
			int ancho = dimensiones[i][0]; //9
			int largo = dimensiones[i][1]; //3
			for(int j = 0; j< i; j++) {
				if(((ancho <= dimensiones[j][0] && dimensiones[j][1] <= largo) || (ancho <= dimensiones[j][1] && dimensiones[j][0] <= largo )))
					break;
				if(i-1 == j) 
					pilas++;
			}
		}
		return pilas;
	}
	
	public Signal deleteSegments(int[] signal, int[] volume) {
		int[] signalCopy  = new int[signal.length];
		int[] volumeCopy = new int[volume.length];
		int j=0;
		for(int i=0;i<signal.length;i++) {
			if(volume[i] >= 10) {
				signalCopy[j] = signal[i];
				volumeCopy[j] = volume[i];
				j++;
			}	
		}
		 
		signalCopy = Arrays.copyOf(signalCopy, j);
		volumeCopy = Arrays.copyOf(volumeCopy, j);
		
		return new Signal(signalCopy,volumeCopy);
		
	}
	
	public void insertionSort(int[] arr) {
		int aux;
		for(int i=1;i < arr.length; i++) {
			aux = arr[i];
			int j= i-1;
			while(j>=0 && aux < arr[j]) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = aux;
		}
		
	}
	
	public int calcularPico(int[] vector, int li, int lf) {
		int p = (li+lf) /2;
		if(vector[p-1] < vector[p] && vector[p] > vector[p+1])
			return p;
		else if(vector[p+1] > vector[p])
				return calcularPico(vector,p+1,lf);
		else return calcularPico(vector,li,p-1);
	}
}


class Signal {
	private int[] signal;
	private int[] volume;
	
	public Signal(int[] signal, int[] volume) {
		this.signal = signal;
		this.volume = volume;
	}
}