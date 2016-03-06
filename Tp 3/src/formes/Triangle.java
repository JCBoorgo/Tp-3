package formes;
/**
 * Classe qui permet de générer et gérer des triangles
 * @author Jean-Christophe Bourgault et David-Alexandre Deshaies-Lévesque
 * @version 0.0.0
 */
import exceptions.FormeException;

public class Triangle extends Forme {
	private int coteA = 0;
	private int coteB = 0;
	private int coteC = 0;

	/**
	 * Constructeur des triangles, prend les trois côtés en paramètre et crée le
	 * triangle s'il est valide. Assigne aussi le nom "Triangle"
	 * 
	 * @param a
	 *            côté du triangle
	 * @param b
	 *            côté du triangle
	 * @param c
	 *            côté du triangle
	 * @throws FormeException
	 *             si le triangle est invalide
	 */
	public Triangle(int a, int b, int c) throws FormeException {
		super("Triangle");
		if (validerTriangle(a, b, c) && estTriangle(a, b, c)) {
			setCoteA(a);
			setCoteB(b);
			setCoteC(c);
		} else {
			throw new FormeException();
		}
	}

	/**
	 * Donne le périmètre du triangle
	 * 
	 * @return périmètre
	 */
	public int calculerPerimetre() {
		return coteA + coteB + coteC;
	}

	/**
	 * Donne la surface du triangle
	 * 
	 * @return surface
	 */
	public int calculerSurface() {
		double p = (double) this.calculerPerimetre() / 2;
		return (int) Math.sqrt(p * (p - this.getCoteA()) * (p - this.getCoteB()) * (p - this.getCoteC()));
	}

	/**
	 * Trie les côtés en ordre croissant
	 * 
	 * @return un tableau de trois entiers avec les côtés triés en ordre
	 *         croissant
	 */
	private int[] getCotesTries() {
		int[] tabTemp = { this.getCoteA(), this.getCoteB(), this.getCoteC() };
		for (int i = 0; i < tabTemp.length - 1; i++) {
			for (int j = i + 1; j < tabTemp.length; j++) {
				if (tabTemp[i] > tabTemp[j]) {
					int temp = tabTemp[i];
					tabTemp[i] = tabTemp[j];
					tabTemp[j] = temp;
				}
			}
		}
		return tabTemp;
	}

	/**
	 * Donne le nombre de côtés égaux que comprend le triangle
	 * 
	 * @return nombre de côtés égaux
	 */
	private int getNbrCoteEgaux() {
		int[] mesures = this.getCotesTries();
		int cotesEgaux = 1;
		if (mesures[0] == mesures[1]) {
			cotesEgaux++;
		}
		if (mesures[1] == mesures[2]) {
			cotesEgaux++;
		}
		return cotesEgaux;
	}

	/**
	 * Détermine si le triangle est rectangle, isocèle, équilatéral ou scalène
	 * 
	 * @return type du triangle
	 */
	public TypeTriangle getType() {
		TypeTriangle type = null;
		if (this.estRectangle()) {
			type = TypeTriangle.RECTANGLE;
		}
		int cotesEgaux = this.getNbrCoteEgaux();
		if (cotesEgaux == 2) {
			type = TypeTriangle.ISOCELE;
		}
		if (cotesEgaux == 3) {
			type = TypeTriangle.EQUILATERAL;
		}
		if (type == null) {
			type = TypeTriangle.SCALENE;
		}
		return type;
	}

	/**
	 * Détermine si le triangle est rectangle
	 * 
	 * @return vrai si le triangle est rectangle
	 */
	public boolean estRectangle() {
		int[] cotes = this.getCotesTries();
		return (getCoteC() * getCoteC() == (cotes[0] * cotes[0]) + (cotes[1] * cotes[1]));
	}

	/**
	 * Donne la mesure du côté A
	 * 
	 * @return mesure du côté A
	 */
	public int getCoteA() {
		return coteA;
	}

	/**
	 * Change la mesure du côté A si elle est entre MIN_VAL et MAX_VAL
	 */
	public void setCoteA(int coteA) {
		if (validerCote(coteA)) {
			this.coteA = coteA;
		}
	}

	/**
	 * Donne la mesure du côté B
	 * 
	 * @return mesure du côté B
	 */
	public int getCoteB() {
		return coteB;
	}

	/**
	 * Change la mesure du côté B si elle est entre MIN_VAL et MAX_VAL
	 */
	public void setCoteB(int coteB) {
		if (validerCote(coteB)) {
			this.coteB = coteB;
		}
	}

	/**
	 * Donne la mesure du côté C
	 * 
	 * @return mesure du côté C
	 */
	public int getCoteC() {
		return coteC;
	}

	/**
	 * Change la mesure du côté C si elle est entre MIN_VAL et MAX_VAL
	 */
	public void setCoteC(int coteC) {
		if (validerCote(coteC)) {
			this.coteC = coteC;
		}
	}

	/**
	 * Vérifie si les mesures du triangle sont valides, c'est-à-dire entre
	 * MIN_VAL et MAX_VAL
	 * 
	 * @param a
	 *            un côté du triangle
	 * @param b
	 *            un côté du triangle
	 * @param c
	 *            un côté du triangle
	 * @return vrai si les mesures sont valides
	 */
	private static boolean validerTriangle(int a, int b, int c) {
		return ((a >= MIN_VAL) && (a <= MAX_VAL) && (b >= MIN_VAL) && (b <= MAX_VAL) && (c >= MIN_VAL)
				&& (c <= MAX_VAL));

	}

	/**
	 * Vérifie si la mesure passée en paramètre est entre MIN_VAL et MAX_VAL
	 * 
	 * @param a
	 * @return vrai si la mesure est entre MIN_VAL et MAX_VAL
	 */
	private static boolean validerCote(int a) {
		return ((a >= MIN_VAL) && (a <= MAX_VAL));
	}

	/**
	 * Vérifie si le triangle est valide, c'est-à-dire si chaque côté du
	 * triangle est plus petit que la somme des deux autres
	 * 
	 * @param a
	 *            un côté du triangle
	 * @param b
	 *            un côté du triangle
	 * @param c
	 *            un côté du triangle
	 * @return vrai si le triangle est valide
	 */
	private static boolean estTriangle(int a, int b, int c) {
		return ((a < (b + c)) || (b < (a + c)) || (c < (a + b)));
	}

	/**
	 * Donne la couleur du triangle, son type et les mesures de ses côtés
	 */
	@Override
	public String toString() {
		return super.toString() + " " + this.getType().toString() + " " + this.getCoteA() + ", " + this.getCoteB()
				+ ", " + this.getCoteC();
	}
}
