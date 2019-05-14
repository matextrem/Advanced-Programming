package com.tpa.conceptos;

public class PruebasConstructores2 {
	
	// Output: Compilation error. ClaseC() constructor is not defined and ClaseA() constructor is not visible.
	
	public static void main(String[] args) {
		System.out.println("Pruebas 2");
		ClaseC o = new ClaseC(1);
		ClaseB o2 = new ClaseC(1);
		ClaseB o3 = new ClaseC();
		ClaseA o4 = new ClaseA();
	}

}

class ClaseA {
	private ClaseA() {
		System.out.print(10);
	}
}

class ClaseB extends ClaseA {
	public ClaseB() {
		System.out.print(20);
	}
}

class ClaseC extends ClaseB {
	public ClaseC(int A) { 
		System.out.print (30); 
	} 
}