package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exceptions.FormeException;
import formes.Cercle;
import formes.Couleur;
import formes.Rectangle;
import formes.Triangle;

public class FormeTest {
	private Triangle t1, t2;
	private Rectangle r1, r2;
	private Cercle c1, c2;

	@Before
	public void setUp() throws Exception {
		t1 = new Triangle(5, 4, 6);
		t2 = new Triangle(7, 2, 6);
		r1 = new Rectangle(7, 2);
		r2 = new Rectangle(8, 6);
		c1 = new Cercle(8);
		c2 = new Cercle(6);
	}

	@Test
	public void testSetCouleur() {
		t1.setCouleur(Couleur.NOIR);
		assertTrue(t1.getCouleur() == Couleur.NOIR);
		r1.setCouleur(Couleur.BLEU);
		assertTrue(r1.getCouleur() == Couleur.BLEU);
		c1.setCouleur(Couleur.VERT);
		assertTrue(c1.getCouleur() == Couleur.VERT);
	}

	@Test
	public void testEqualsObject() {
		assertFalse(t1.equals(t2));
		assertFalse(c1.equals(null));
		try {
			Rectangle r3 = new Rectangle(7, 2);
			assertTrue(r1.equals(r3));
			r3.setCouleur(Couleur.JAUNE);
			assertFalse(r1.equals(r3));
		} catch (FormeException e) {
		}
	}

	@Test
	public void testCompareTo() {
		//Même objet
		assertTrue(c1.compareTo(c1) == 0);
		//Même nom, même couleur
		assertTrue(c1.compareTo(c2) == 0);
		//Noms différents
		assertTrue(c1.compareTo(r1) < 0);
		assertTrue(r1.compareTo(t1) < 0);
		assertTrue(c1.compareTo(t1) < 0);
		//Même nom, couleur différente
		t2.setCouleur(Couleur.NOIR);
		assertTrue(t1.compareTo(t2) < 0);
		r2.setCouleur(Couleur.BLEU);
		assertTrue(r1.compareTo(r2) < 0);
	}

}
