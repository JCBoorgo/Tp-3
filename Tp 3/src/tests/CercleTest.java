package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exceptions.FormeException;
import formes.Cercle;
import formes.Couleur;

public class CercleTest {

	private Cercle c1, c2, c3, c4;
	//TODO MODIFIER
	@Before
	public void setUp() throws Exception {
		try {
			c1 = new Cercle(1);
			c2 = new Cercle(5);
			c3 = new Cercle(11);
			c4 = new Cercle(28);
		} catch (FormeException e) {
		}
	}

	@After
	public void tearDown() throws Exception {
		c1 = null;
		c2 = null;
	}

	@Test
	public void testCercle() {
		// Cercles invalides
		try {
			Cercle c5 = new Cercle(Cercle.MIN_VAL - 1);
			fail();
		} catch (FormeException e) {

		}
		try {
			Cercle c6 = new Cercle(Cercle.MAX_VAL + 1);
			fail();
		} catch (FormeException e) {

		}
	}

	@Test
	public void testCalculerSurface() {
		assertTrue(c1.calculerSurface() == (int) Math.PI);
		assertTrue(c2.calculerSurface() == (int) (5 * 5 * Math.PI));
	}

	@Test
	public void testCalculerPerimetre() {
		assertTrue(c1.calculerPerimetre() == (int) (Math.PI * 2));
		assertTrue(c2.calculerPerimetre() == (int) (5 * 2 * Math.PI));
	}

	@Test
	public void testEqualsObject() {
		// Equals null
		assertFalse(c1.equals(null));
		// Objets complètement différents
		assertFalse(c1.equals(c2));
		// Comparaison avec lui-même
		assertTrue(c1.equals(c1));
		try {
			// Mêmes valeurs, objet différent
			Cercle c5 = new Cercle(1);
			assertTrue(c1.equals(c5));
			c5.setCouleur(Couleur.BLEU);
			// Mêmes valeurs, couleurs différentes
			assertFalse(c1.equals(c5));
		} catch (FormeException e) {
		}
	}

	@Test
	public void testToString() {
		assertTrue(c1.toString().equals("Cercle rouge 1"));
		assertTrue(c2.toString().equals("Cercle rouge 5"));
		// Couleur autre que rouge
		c1.setCouleur(Couleur.BLEU);
		assertTrue(c1.toString().equals("Cercle bleu 1"));
	}

	@Test
	public void testSetRayon() {
		// Borne supérieure
		c1.setRayon(Cercle.MAX_VAL);
		assertTrue(c1.getRayon() == Cercle.MAX_VAL);
		// Trop haut
		c2.setRayon(Cercle.MAX_VAL + 1);
		assertTrue(c2.getRayon() == 5);
		// Borne inférieure
		c3.setRayon(Cercle.MIN_VAL);
		assertTrue(c3.getRayon() == Cercle.MIN_VAL);
		// Trop bas
		c4.setRayon(Cercle.MIN_VAL - 1);
		assertTrue(c4.getRayon() == 28);
	}
}
