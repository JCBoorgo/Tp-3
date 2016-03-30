package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import formes.Cercle;
import formes.Couleur;
import formes.Forme;
import formes.Rectangle;
import formes.Triangle;
import formes.VecteurFormes;

public class VecteurFormesTest {
	VecteurFormes v1, v2, v3;

	@Before
	public void setUp() throws Exception {
		v1 = new VecteurFormes();
		ArrayList<Forme> p1 = v1.getVecteur();
		// CRÉATION DU VECTEUR PARFAIT DE TAILLE 36 NON MÉLANGÉ
		for (int i = 0; i < 2; i++) {
			p1.add(new Triangle(Forme.MIN_VAL, Forme.MIN_VAL, Forme.MIN_VAL));
			p1.get(p1.size() - 1).setCouleur(Couleur.ORANGE);
			p1.add(new Triangle(Forme.MIN_VAL, Forme.MIN_VAL, Forme.MIN_VAL));
			p1.get(p1.size() - 1).setCouleur(Couleur.NOIR);
			p1.add(new Triangle(Forme.MIN_VAL, Forme.MIN_VAL, Forme.MIN_VAL));
			p1.get(p1.size() - 1).setCouleur(Couleur.JAUNE);
			p1.add(new Triangle(Forme.MIN_VAL, Forme.MIN_VAL, Forme.MIN_VAL));
			p1.get(p1.size() - 1).setCouleur(Couleur.BLEU);
			p1.add(new Triangle(Forme.MIN_VAL, Forme.MIN_VAL, Forme.MIN_VAL));
			p1.get(p1.size() - 1).setCouleur(Couleur.VERT);
			p1.add(new Triangle(Forme.MIN_VAL, Forme.MIN_VAL, Forme.MIN_VAL));
			p1.get(p1.size() - 1).setCouleur(Couleur.ROUGE);
			p1.add(new Rectangle(Forme.MIN_VAL, Forme.MIN_VAL));
			p1.get(p1.size() - 1).setCouleur(Couleur.ORANGE);
			p1.add(new Rectangle(Forme.MIN_VAL, Forme.MIN_VAL));
			p1.get(p1.size() - 1).setCouleur(Couleur.NOIR);
			p1.add(new Rectangle(Forme.MIN_VAL, Forme.MIN_VAL));
			p1.get(p1.size() - 1).setCouleur(Couleur.JAUNE);
			p1.add(new Rectangle(Forme.MIN_VAL, Forme.MIN_VAL));
			p1.get(p1.size() - 1).setCouleur(Couleur.BLEU);
			p1.add(new Rectangle(Forme.MIN_VAL, Forme.MIN_VAL));
			p1.get(p1.size() - 1).setCouleur(Couleur.VERT);
			p1.add(new Rectangle(Forme.MIN_VAL, Forme.MIN_VAL));
			p1.get(p1.size() - 1).setCouleur(Couleur.ROUGE);
			p1.add(new Cercle(Forme.MIN_VAL));
			p1.get(p1.size() - 1).setCouleur(Couleur.ORANGE);
			p1.add(new Cercle(Forme.MIN_VAL));
			p1.get(p1.size() - 1).setCouleur(Couleur.NOIR);
			p1.add(new Cercle(Forme.MIN_VAL));
			p1.get(p1.size() - 1).setCouleur(Couleur.JAUNE);
			p1.add(new Cercle(Forme.MIN_VAL));
			p1.get(p1.size() - 1).setCouleur(Couleur.BLEU);
			p1.add(new Cercle(Forme.MIN_VAL));
			p1.get(p1.size() - 1).setCouleur(Couleur.VERT);
			p1.add(new Cercle(Forme.MIN_VAL));
			p1.get(p1.size() - 1).setCouleur(Couleur.ROUGE);

		}
		v2 = new VecteurFormes();
		v2.remplir(36);
		v3 = new VecteurFormes();
		v3.remplir(36);
	}

	@Test
	public void testRemplir() {
		assertTrue(v1.toString().equals(v2.toString()));
	}

	@Test
	public void testTrier() {
		fail("Not yet implemented");
	}

	@Test
	public void testMelanger() {
		int pareils = 0;
		ArrayList<Forme> p2 = v2.getVecteur();
			v3.melanger();
			ArrayList<Forme> p3 = v3.getVecteur();
			for (int i = 0; i < 36; i++) {
				if (p2.get(i).equals(p3.get(i))) {
					pareils++;
				}
			}
		assertTrue(pareils < (7));
	}

}
