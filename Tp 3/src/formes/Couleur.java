package formes;

/**
 * Énumération qui gère les couleurs
 * 
 * @author Jean-Christophe Bourgault et David-Alexandre Deshaies-Lévesque
 * @version 0.0.0
 */
public enum Couleur {
	ROUGE("rouge"), VERT("vert"), BLEU("bleu"), JAUNE("jaune"), NOIR("noir"), ORANGE("orange");

	private String nom = null;

	/**
	 * Constructeur des couleurs
	 * 
	 * @param nom
	 */
	Couleur(String nom) {
		this.nom = nom;
	}

	/**
	 * Donne le nom de la couleur
	 * 
	 * @return nom de la couleur
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Assigne le nom à la couleur
	 * 
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Donne le nom de la couleur
	 * 
	 * @return nom de la couleur
	 */
	@Override
	public String toString() {
		return getNom();
	}
}
