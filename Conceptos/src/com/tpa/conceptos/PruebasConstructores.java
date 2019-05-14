package com.tpa.conceptos;

public class PruebasConstructores {
	
	/* Output
	 * Pruebas 1 
	 * 123
	 * 123
	*/
	
	public static void main(String[] args) {
		System.out.println("Pruebas 1");
		Clase3 o = new Clase3();
		Clase2 o2 = new Clase3();
	}

}

class Clase1 {
	public Clase1() {
		System.out.print("1");
	}
}

class Clase2 extends Clase1 {
	public Clase2() {
		System.out.print("2");
	}
}

class Clase3 extends Clase2 {
	public Clase3() {
		System.out.println("3");
	}
}