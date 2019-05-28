package com.tpa.conceptos;

public abstract class Employee {
	protected abstract double getSalesAmount();
	public double getCommision() {
		return getSalesAmount() * 0.15;
	}

}
