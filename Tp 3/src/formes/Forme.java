package formes;

/**
 * Classe abstraite qui gère les formes
 * @author Jean-Christophe Bourgault et David-Alexandre Deshaies-Lévesque
 * @version 0.0.0
 */
import exceptions.FormeException;

abstract public class Forme implements Comparable<Forme> {
	public static final int MIN_VAL = 1;
	public static final int MAX_VAL = 30;
	public static final Couleur COULEUR_DEFAUT = Couleur.ROUGE;

	private String nom = null;
	private Couleur couleur = null;

	/**
	 * Constructeur des formes
	 * 
	 * @param nom
	 * @throws FormeException
	 */
	public Forme(String nom) throws FormeException {
		this.setCouleur(COULEUR_DEFAUT);
		this.nom = nom;
	}

	/**
	 * Donne la surface de la forme
	 * 
	 * @return surface
	 */
	public abstract int calculerSurface();

	/**
	 * Donne le périmètre de la forme
	 * 
	 * @return périmètre
	 */
	public abstract int calculerPerimetre();

	/**
	 * Donne la couleur de la forme
	 * 
	 * @return couleur
	 */
	public Couleur getCouleur() {
		return couleur;
	}

	/**
	 * Change la couleur de la forme
	 * 
	 * @param couleur
	 */
	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	/**
	 * Donne le nom de la forme
	 * 
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Compare la surface, la couleur et le nom des formes pour déterminer leur
	 * égalité
	 */
	@Override
	public boolean equals(Object obj) {
		boolean valide = false;
		Forme object = (Forme) obj;

		if (obj instanceof Forme) {
			valide = ((this.calculerSurface() == object.calculerSurface())
					&& (this.getCouleur().equals(object.getCouleur())) && (this.getNom().equals(object.getNom())));
		}
		return valide;
	}

	/**
	 * Retourne le nom et la couleur de la forme
	 */
	@Override
	public String toString() {
		return (getNom() + " " + getCouleur());
	}

	/**
	 * Retourne le nom et la couleur de la forme
	 * @return nom et couleur de la forme
	 */
	public String toStringCourt() {
		return (getNom() + " " + getCouleur());
	}

	/**
	 * Compare par nom, puis par couleur pour déterminer l'ordre
	 */
	@Override
	public int compareTo(Forme o) {
		int valeur = this.getNom().compareTo(o.getNom());
		if (valeur == 0) {
			valeur = this.getCouleur().compareTo(o.getCouleur());
		}
		return valeur;
	}

	/**
	 * Change le nom de la forme
	 * @param nom
	 */
	public void setNom(String nom) {
		if (nom != null) {
			this.nom = nom;
		}
	}
}
