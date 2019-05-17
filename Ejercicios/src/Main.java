import java.io.FileNotFoundException;

public class Main {
	
	public static void main(String[] args) {
		Pruebas myObject = new Pruebas();
		// System.out.println("Cantidad de movimientos: " + myObject.zapatos(8,new int[] {0,1,2,1,3,4,2,3}));
		// System.out.println("Cantidad de movimientos 2: " + myObject.zapatos(7,new int[] {3,6,4,8,6,6,2}));
		// System.out.println("Cantidad de pilas de mesadas: " + myObject.mesadas(5,new int[][] {{10,6},{10,8},{11,9},{12,8},{14,9}}));
		// System.out.println("Cantidad de pilas de mesadas 2: " + myObject.mesadas(17,new int[][] {{9,15},{64,20},{26,46},{30,51},{74,76},{53,20},{66,92},{90,71},{31,93},{75,59},{24,39},{99,40},{13,56},{95,50},{3,82},{43,68},{2,50}}));
		
		// Pre parcial
		
		int[] signal = {0,4,6,566};
		int[] volume = {5,8,20,7};
		
		int[] arraySort = {3,4,2,1,5};
		int[] arrayPico = {1,2,3,1,0,-2};
		
		Signal result = myObject.deleteSegments(signal, volume); // Pre-parcial
		// myObject.insertionSort(arraySort);
		//System.out.println(arraySort);
		// System.out.println(myObject.calcularPico(arrayPico, 0, arrayPico.length - 1));
	
		
		PaisesLimitrofes paisObject = new PaisesLimitrofes();
		try {
			paisObject.armarGrafo();
			paisObject.escribirPaises();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


