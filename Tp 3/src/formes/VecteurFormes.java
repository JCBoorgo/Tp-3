package formes;

/**
 * Classe qui gère les vecteurs de Forme
 * @author Jean-Christophe Bourgault et David-Alexandre Deshaies-Lévesque
 * @version 0.0.0
 */
import java.util.ArrayList;

import exceptions.FormeException;

public class VecteurFormes implements ManipulerVecteur {
	private ArrayList<Forme> vecteur = null;

	/**
	 * Constructeur des VecteurFormes
	 */
	public VecteurFormes() {
		vecteur = new ArrayList<Forme>();
	}

	/**
	 * Valide si le nombre passé en paramètre est positif
	 * 
	 * @param pNbrFormes
	 * @return vrai si le nombre en paramètre est positif
	 */
	private boolean validerNbrFormes(int pNbrFormes) {
		return (pNbrFormes >= 0);
	}

	/**
	 * Génère autant de formes que demandées dans le paramètre. Les attributs
	 * des formes sont distribués uniformément.
	 * 
	 * @param nbrFormes
	 */
	public void remplir(int nbrFormes) {
		if (validerNbrFormes(nbrFormes)) {
			int formesFaites = 0;
			ArrayList<Forme> tabDeBase = new ArrayList<Forme>();
			for (Couleur coul : Couleur.values()) {
				try {
					tabDeBase.add(new Cercle(Forme.MIN_VAL));
					tabDeBase.get(tabDeBase.size() - 1).setCouleur(coul);
				} catch (FormeException e) {
				}
			}
			for (Couleur coul : Couleur.values()) {
				try {
					tabDeBase.add(new Rectangle(Forme.MIN_VAL, Forme.MIN_VAL));
					tabDeBase.get(tabDeBase.size() - 1).setCouleur(coul);
				} catch (FormeException e) {
				}
			}
			for (Couleur coul : Couleur.values()) {
				try {
					tabDeBase.add(new Triangle(Forme.MIN_VAL, Forme.MIN_VAL, Forme.MIN_VAL));
					tabDeBase.get(tabDeBase.size() - 1).setCouleur(coul);
				} catch (FormeException e) {
				}
			}
			ArrayList<Forme> tabAPige = new ArrayList<Forme>();
			tabAPige.addAll(tabDeBase);
			do {
				if (tabAPige.isEmpty()) {
					tabAPige.addAll(tabDeBase);
				}
				this.vecteur.add(tabAPige.get(tabAPige.size() - 1));
				tabAPige.remove(tabAPige.size() - 1);
				formesFaites++;
			} while (formesFaites < nbrFormes);
		}
	}

	/**
	 * Génère une chaîne comportant le nom et la couleur de chaque forme du
	 * vecteur
	 */
	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < vecteur.size() - 1; i++) {
			s += vecteur.get(i).toStringCourt();
		}
		return s;
	}

	/**
	 * Trie le vecteur en utilisant son compareTo
	 */
	public void trier() {
		boolean changement = false;
		do {
			changement = false;
			for (int i = 0; i < vecteur.size() - 2; i++) {
				if (vecteur.get(i).compareTo(vecteur.get(i + 1)) > 0) {
					permuter(i, i + 1);
					changement = true;
				}
			}
		} while (changement = true);
	}

	/**
	 * Mélange le vecteur en permutant deux éléments [nombre d'éléments dans le
	 * vecteur multiplié par 10] fois
	 */
	public void melanger() {
		int nbrFois = vecteur.size() * 10; // nombre de fois arbitraire
		for (int i = 0; i < nbrFois; i++) {
			int indUn = (int) Math.round(Math.random() * (vecteur.size() - 1));
			int indDeux = (int) Math.round(Math.random() * (vecteur.size() - 1));
			this.permuter(indUn, indDeux);
		}
	}

	/**
	 * Échange les éléments aux indices passés en paramètre
	 * 
	 * @param premier
	 * @param dernier
	 */
	private void permuter(int premier, int dernier) {
		Forme temp = this.vecteur.get(dernier);
		this.vecteur.set(dernier, this.vecteur.get(premier));
		this.vecteur.set(premier, temp);
	}

	/**
	 * Retourne une référence vers le vecteur
	 * 
	 * @return pointeur vers le vecteur
	 */
	public ArrayList<Forme> getVecteur() {
		return this.vecteur;
	}
}
