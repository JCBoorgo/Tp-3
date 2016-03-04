package formes;

import java.util.ArrayList;

public interface ManipulerVecteur {
	public ArrayList<Forme> getVecteur();
	@Override
	String toString();
	public void remplir(int nbrElements);
	public void trier();
	public void melanger();
}
