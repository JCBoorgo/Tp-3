package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exceptions.FormeException;
import formes.Couleur;
import formes.Forme;
import formes.Triangle;
import formes.TypeTriangle;

public class TriangleTest {

	private Triangle t1, t2, t3, t4;

	@Before
	public void setUp() throws Exception {
		t1 = new Triangle(1, 1, 1);
		t2 = new Triangle(3, 4, 5);
		t3 = new Triangle(15, 7, 12);
		t4 = new Triangle(11, 23, 18);
	}

	@Test
	public void testCalculerSurface() {
		assertTrue(t1.calculerSurface() == 0);
		assertTrue(t2.calculerSurface() == 6);
		assertTrue(t3.calculerSurface() == 41);
		assertTrue(t4.calculerSurface() == 96);
	}

	@Test
	public void testCalculerPerimetre() {
		assertTrue(t1.calculerPerimetre() == 3);
		assertTrue(t2.calculerPerimetre() == 12);
		assertTrue(t3.calculerPerimetre() == 34);
		assertTrue(t4.calculerPerimetre() == 52);
	}

	@Test
	public void testToString() {
		t1.setCouleur(Couleur.ORANGE);
		assertTrue(t2.toString().equals("Triangle rouge rectangle 3, 4, 5"));
		assertTrue(t1.toString().equals("Triangle orange equilateral 1, 1, 1"));
	}

	@Test
	public void testTriangle() {
		try {
			Triangle t5 = new Triangle(Forme.MIN_VAL - 1, 15, 15);
			fail();
		} catch (FormeException e) {
		}
		try {
			Triangle t6 = new Triangle(Forme.MAX_VAL + 1, 15, 15);
			fail();
		} catch (FormeException e) {
		}
		// Les autres côtés fonctionnent pareil
	}

	@Test
	public void testGetType() {
		assertTrue(t1.getType() == TypeTriangle.EQUILATERAL);
		assertTrue(t2.getType() == TypeTriangle.RECTANGLE);
		assertTrue(t3.getType() == TypeTriangle.SCALENE);
		assertTrue(t4.getType() == TypeTriangle.SCALENE);
	}

	@Test
	public void testEstRectangle() {
		assertFalse(t1.estRectangle());
		assertTrue(t2.estRectangle());
		assertFalse(t3.estRectangle());
	}

	@Test
	public void testSetCoteA() {
		t1.setCoteA(21);
		assertTrue(t1.getCoteA() == 21);
		t2.setCoteA(Forme.MAX_VAL + 1);
		assertFalse(t2.getCoteA() == (Forme.MAX_VAL + 1));
		t2.setCoteA(Forme.MIN_VAL - 1);
		assertFalse(t2.getCoteA() == (Forme.MIN_VAL - 1));
	}

	@Test
	public void testSetCoteB() {
		t1.setCoteB(21);
		assertTrue(t1.getCoteB() == 21);
		t2.setCoteB(Forme.MAX_VAL + 1);
		assertFalse(t2.getCoteB() == (Forme.MAX_VAL + 1));
		t2.setCoteB(Forme.MIN_VAL - 1);
		assertFalse(t2.getCoteB() == (Forme.MIN_VAL - 1));
	}

	@Test
	public void testSetCoteC() {
		t1.setCoteC(21);
		assertTrue(t1.getCoteC() == 21);
		t2.setCoteC(Forme.MAX_VAL + 1);
		assertFalse(t2.getCoteC() == (Forme.MAX_VAL + 1));
		t2.setCoteC(Forme.MIN_VAL - 1);
		assertFalse(t2.getCoteC() == (Forme.MIN_VAL - 1));
	}

}
