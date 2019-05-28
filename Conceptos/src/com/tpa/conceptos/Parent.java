package com.tpa.conceptos;

public class Parent {
	public static void main(String[] args) {
		new Child();
	}
	public Parent() {
		System.out.print("A");
	}

}

class Child extends Parent {
	public Child(int x) {
		System.out.print("B");
	}
	
	public Child() {
		this(123);
		System.out.print("C");
	}
}