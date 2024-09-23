package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		assert force > 0;
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert force >= 0;
		int initForce = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		assert force < initForce;
	}
	
	public static void main(String[] args) {
		Romain romain = new Romain("Minus",1);
		//System.out.println(romain.prendreParole());
		romain.parler("Le romain parle");
		romain.recevoirCoup(1);
		romain.recevoirCoup(1);
	}
}
