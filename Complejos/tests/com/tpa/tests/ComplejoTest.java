package com.tpa.tests;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.tpa.complejos.Complejo;
import com.tpa.complejos.ComplejosPorParteReal;

public class ComplejoTest {
	@Test
	public void queSuma() {
		Complejo c1 = new Complejo(1,2);
		Complejo c2 = new Complejo(2,3);
		Complejo c3 = new Complejo(3,5);
		Assert.assertEquals(c3,c1.sumar(c2));
	}
	
	@Test
	public void queUnMenorEsMenor() {
		Complejo c1 = new Complejo(1,0);
		Complejo c2 = new Complejo(2,0);
		Assert.assertEquals(-1, c1.compareTo(c2),0.0);
	}
	
	@Test
	public void queOrdenaNaturalmente() {
		Complejo[] original = {
				new Complejo(3,1),
				new Complejo(2,1),
				new Complejo(5,1),			
		};
		
		Complejo[] ordenado = {
				new Complejo(2,1),
				new Complejo(3,1),
				new Complejo(5,1),			
		};
		
		Arrays.sort(original);
		
		Assert.assertArrayEquals(ordenado, original);
	}

	@Test
	public void queOrdenaPorParteReal() {
		Complejo[] original = {
				new Complejo(3,1),
				new Complejo(2,4),
				new Complejo(5,5),			
		};
		
		Complejo[] ordenado = {
				new Complejo(2,4),
				new Complejo(3,1),
				new Complejo(5,5),			
		};
		
		Arrays.sort(original, new ComplejosPorParteReal());
		
		Assert.assertArrayEquals(ordenado, original);
	}
}
