package jeu;

import java.awt.Point;
import java.util.ArrayList;

import formes.Forme;
import formes.VecteurFormes;

public class JeuMemoire implements Memorable {
	public final static int LIGNE = 6;
	public final static int COLONNE = 6;
	public final static int NBR_ELEMENTS_GRILLE = LIGNE * COLONNE;
	private final static int LONGUEUR_CHAINE = 17;

	private ArrayList<Point> vecteurPoints = null;
	private int niveau = 0;
	private VecteurFormes vecteurFormes = null;
	private Forme[][] grilleDeJeu = null;

	public JeuMemoire() {
		preparerVecteurFormes();
		preparerGrilleDeJeu();
		this.niveau = 1;
	}

	private void preparerVecteurFormes() {
		vecteurFormes = new VecteurFormes();
		vecteurFormes.remplir(NBR_ELEMENTS_GRILLE);
		vecteurFormes.melanger();
	}

	private void preparerGrilleDeJeu() {
		grilleDeJeu = new Forme[LIGNE][COLONNE];
		int formeCompteur = 0;
		ArrayList<Forme> vecteur = vecteurFormes.getVecteur();
		for (int i = 0; i < LIGNE; i++) {
			for (int j = 0; j < COLONNE; i++) {
				grilleDeJeu[i][j] = vecteur.get(formeCompteur);
				formeCompteur++;
			}
		}
	}

	public String toString() {
		String chaine = "";
		for (int i = 0; i < LIGNE; i++) {
			for (int j = 0; j < COLONNE; i++) {
				chaine += ajouterEspaces(LONGUEUR_CHAINE, grilleDeJeu[i][j].toStringCourt());
				chaine += "|";
			}
			chaine += "/n";
		}
		return null;
	}

	private String ajouterEspaces(int longueur, String s) {
		while (s.length() < longueur) {
			s += " ";
		}
		return s;
	}

	public String getNomForme(int x, int y) {
		return grilleDeJeu[x][y].toStringCourt().replaceAll(" ", "");
	}

	public ArrayList<Point> jouerOrdi() {
		int compteur = 0;
		ArrayList<Point> pointsOrdi = new ArrayList<>();
		while (compteur < niveau + 2) {
			boolean valide = false;
			while (valide == false) {
				boolean pareil = false;
				Point point = new Point(choisirForme());
				for (int i = 0; i < pointsOrdi.size(); i++) {
					if (point.equals(pointsOrdi.get(i))) {
						pareil = true;
					}
				}
				if (pareil == false) {
					pointsOrdi.add(point);
					valide = true;
				}
			}
		}
		return pointsOrdi;
	}

	private Point choisirForme() {
		return new Point((int) Math.floor(Math.random() * LIGNE), (int) Math.floor(Math.random() * COLONNE));
	}

	public boolean jouerHumain(int x, int y) {
		Point pointHumain = new Point(x, y);
		boolean valide = false;
		if (pointHumain.equals(vecteurPoints.get(0))) {
			valide = true;
			vecteurPoints.remove(0);
		}
		return valide;
	}

	public void setNiveauPlusUn() {
		if (this.niveau < 6) {
			this.niveau++;
		}
	}

	public int getNiveau() {
		return this.niveau;
	}
}
