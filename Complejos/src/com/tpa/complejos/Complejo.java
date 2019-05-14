package com.tpa.complejos;

public class Complejo implements Comparable <Complejo> {
	 Double real;
	 Double imaginario;
	
	public Complejo(double real, double imaginario) {
		super();
		this.real = real;
		this.imaginario = imaginario;
	}
	
	public Complejo sumar(Complejo n1) {
		return new Complejo(n1.real + this.real, n1.imaginario + this.imaginario);
	}
	
	public Complejo sumar(double n1) {
		return new Complejo(n1 + this.real, this.imaginario);
	}
	
	public Complejo restar(Complejo n1) {
		return new Complejo(n1.real - this.real, n1.imaginario - this.imaginario);

	}
	
	public Complejo restar(double n1) {
		return new Complejo(this.real - n1, this.imaginario); 

	}
	
	public Complejo multiplicar(Complejo n1) {
		return new Complejo((n1.real * this.real) - n1.imaginario * this.imaginario,(n1.real * this.imaginario) + n1.imaginario * this.real);
	}
	
	public Complejo multiplicar(double n1) {
		return new Complejo(this.real*n1, this.imaginario*n1);
	}
	
	public Double modulo() {
		return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imaginario, 2));
	}
	
	public Complejo clonar() {
		return new Complejo(this.real,this.imaginario);
	}

	@Override
	public String toString() {
		return "Complejo [real=" + real + ", imaginario=" + imaginario + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(imaginario);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(real);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Complejo other = (Complejo) obj;
		if (Double.doubleToLongBits(imaginario) != Double.doubleToLongBits(other.imaginario))
			return false;
		if (Double.doubleToLongBits(real) != Double.doubleToLongBits(other.real))
			return false;
		return true;
	}

	@Override
	public int compareTo(Complejo o) {
		// TODO Auto-generated method stub
		return this.modulo().compareTo(o.modulo());
	}	
	 
	                          
}
