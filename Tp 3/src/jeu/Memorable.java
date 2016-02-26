package jeu;

import java.awt.Point;
import java.util.ArrayList;

public interface Memorable {
	public final static int NIVEAU_MAX = 6;
	String toString();
	public ArrayList<Point> jouerOrdi();
	public boolean jouerHumain(int x, int y);
	public String getNomForme(int x, int y);
	public void setNiveauPlusUn();
	public int getNiveau();
}
