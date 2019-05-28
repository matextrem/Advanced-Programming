import java.io.FileNotFoundException;

public class Main {
	
	public static void main(String[] args) {
		// Pruebas myObject = new Pruebas();
		// Rotation rotationObj = new Rotation();
		// System.out.println("Cantidad de movimientos: " + myObject.zapatos(8,new int[] {0,1,2,1,3,4,2,3}));
		// System.out.println("Cantidad de movimientos 2: " + myObject.zapatos(7,new int[] {3,6,4,8,6,6,2}));
		// System.out.println("Cantidad de pilas de mesadas: " + myObject.mesadas(5,new int[][] {{10,6},{10,8},{11,9},{12,8},{14,9}}));
		// System.out.println("Cantidad de pilas de mesadas 2: " + myObject.mesadas(17,new int[][] {{9,15},{64,20},{26,46},{30,51},{74,76},{53,20},{66,92},{90,71},{31,93},{75,59},{24,39},{99,40},{13,56},{95,50},{3,82},{43,68},{2,50}}));
		
		// Pre parcial
		
		int[] signal = {0,4,6,566};
		int[] volume = {5,8,20,7};
		
		int[] arraySort = {3,4,2,1,5};
		int[] rotateArray = {1,2,3,4,5,6,7,8,9};
		int[] arrayPico = {1,2,3,1,0,-2};
	    int[] theArray = {44,5,33,22,765,43,53,12,57,97};

		
		// Signal result = myObject.deleteSegments(signal, volume); // Pre-parcial
		// myObject.shellsort(arraySort);
		// rotationObj.rotate(rotateArray, 3);
	    long startTime = System.currentTimeMillis();
		NombresRepetidos nombresRepeObj = new NombresRepetidos("nombresRepetidosIn.txt");
		// nombresRepeObj.calcularNombres();
		 //nombresRepeObj.escribirArchivo("nombresRepetidosOut.txt");
		long endTime = System.currentTimeMillis();
        System.out.println("It took " + (endTime - startTime) + " milliseconds");
		// System.out.println(arraySort);
		// System.out.println(myObject.calcularPico(arrayPico, 0, arrayPico.length - 1));
        Baldosas baldosasObj = new Baldosas("baldosasIn.txt");
        baldosasObj.pintarBaldosas();
        baldosasObj.escribirArchivo("baldosasOut.txt");
		String str = "ABC"; 
        int n = str.length(); 
        // Permutation permutation = new Permutation(); 
        // permutation.permute(str, 0, n - 1); 
		
		// PaisesLimitrofes paisObject = new PaisesLimitrofes();
		//try {
		//	paisObject.armarGrafo();
		//	paisObject.escribirPaises();
		//} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
	}
}


