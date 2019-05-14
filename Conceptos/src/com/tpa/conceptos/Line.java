package com.tpa.conceptos;

public class Line {
	public static class Point { 
		public Point() {
			System.out.println("Created");
		}
	}
}

class Triangle { 
	Line.Point p = new Line.Point(); 
}