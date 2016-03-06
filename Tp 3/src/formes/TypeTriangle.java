package formes;

/**
 * Énumération qui gère les différents types de triangle
 * 
 * @author Jean-Christophe Bourgault et David-Alexandre Deshaies-Lévesque
 * @version 0.0.0
 */
public enum TypeTriangle {
	ISOCELE("isocele"), EQUILATERAL("equilateral"), RECTANGLE("rectangle"), SCALENE("scalene");

	private String type = null;

	/**
	 * Constructeur des TypeTriangle
	 * 
	 * @param type
	 */
	TypeTriangle(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return getType();
	}
}
