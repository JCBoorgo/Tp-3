package jeu;

import java.awt.Point;
import java.util.ArrayList;

import formes.Forme;
import formes.VecteurFormes;

public class JeuMemoire implements Memorable {
	public final static int LIGNE = 6;
	public final static int COLONNE = 6;
	public final static int NBR_ELEMENTS_GRILLE = LIGNE*COLONNE;
	private final static int LONGUEUR_CHAINE = 17;
	
	private ArrayList<Point> vecteurPoints = null;
	private int niveau = 0;
	private VecteurFormes vecteurFormes = null;
	private Forme[][] grilleDeJeu = null;
	
	public jeuMemoire(){
		//TODO
	}
	
	private void preparerVecteurFormes(){
		//TODO
	}
	
	private void preparerGrilleDeJeu(){
		//TODO
	}
	
	public String toString(){
		//TODO
		return null;
	}
	
	private String ajouterEspaces(int longueur, String s){
		return null;
		//TODO
	}
	
	public String getNomForme(int x, int y){
		return null;
		//TODO
	}
	
	public ArrayList<Point> jouerOrdi(){
		return null;
		//TODO
	}
	
	private Point choisirForme(){
		return null;
		//TODO
	}
	
	public boolean jouerHumain(int x, int y){
		return true;
		//TODO
	}
	
	public void setNiveauPlusUn(){
		//TODO
	}
	
	public int getNiveau(){
		return this.niveau;
	}
}
