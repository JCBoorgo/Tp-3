package formes;

/**
 * Classe qui permet de générer et gérer des cercles
 * 
 * @author Jean-Christophe Bourgault et David-Alexandre Deshaies-Lévesque
 * @version 0.0.0
 */
import exceptions.FormeException;

public class Cercle extends Forme {
	private int rayon = 1;

	/**
	 * Constructeur des cercles qui prend le rayon en paramètre. Utilise le
	 * constructeur de Forme et donne le nom "Cercle"
	 * 
	 * @param rayon
	 *            rayon du cercle
	 * @throws FormeException
	 *             si le rayon n'est pas valide
	 */
	public Cercle(int rayon) throws FormeException {
		super("Cercle");
		if (validerRayon(rayon)) {
			setRayon(rayon);
		} else {
			throw new FormeException();
		}
	}

	/**
	 * Permet de calculer la surface du cercle
	 * 
	 * @return la surface du cercle
	 */
	public int calculerSurface() {
		return (int) (Math.PI * getRayon() * getRayon());
	}

	/**
	 * Permet de calculer le périmètre du cercle
	 * 
	 * @return le périmètre du cercle
	 */
	public int calculerPerimetre() {
		return (int) (Math.PI * getRayon() * 2);
	}

	/**
	 * Donne le nom du cercle, avec sa couleur et son rayon
	 * 
	 * @return Nom, couleur et rayon
	 */
	public String toString() {
		return (super.toString() + " " + this.getRayon());
	}

	/**
	 * Donne le rayon du cercle
	 * 
	 * @return le rayon du cercle
	 */
	public int getRayon() {
		return rayon;
	}

	/**
	 * Change le rayon du cercle s'il entre MIN_VAL et MAX_VAL
	 * 
	 * @param rayon
	 *            rayon désiré
	 */
	public void setRayon(int rayon) {
		if (validerRayon(rayon)) {
			this.rayon = rayon;
		}
	}

	/**
	 * Vérifie si le rayon passé en paramètre est entre MIN_VAL et MAX_VAL
	 * 
	 * @param rayon
	 *            rayon à tester
	 * @return vrai si le rayon est entre MIN_VAL et MAX_VAL
	 */
	private static boolean validerRayon(int rayon) {
		return ((rayon <= MAX_VAL) && (rayon >= MIN_VAL));
	}
}
