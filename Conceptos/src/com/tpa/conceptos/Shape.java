package com.tpa.conceptos;

public class Shape {

	private String color;
	
	public Shape(String color) {
		System.out.print("Shape");
		this.color = color;
	}
	
	public static void main(String[] args) {
		new Rectangle();
	}
}

class Rectangle extends Shape {
	public Rectangle() {
		// super(color);
		System.out.print("Rectangle");
	}
}