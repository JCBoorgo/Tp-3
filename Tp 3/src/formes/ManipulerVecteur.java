package formes;
/**
 * Interface de méthodes pour manipuler des ArrayList de Forme
 * @author Jean-Christophe Bourgault et David-Alexandre Deshaies-Lévesque
 * @version 0.0.0
 */
import java.util.ArrayList;

public interface ManipulerVecteur {
	public ArrayList<Forme> getVecteur();
	@Override
	String toString();
	public void remplir(int nbrElements);
	public void trier();
	public void melanger();
}
