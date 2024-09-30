package personnages;

import java.util.Arrays;

public class Gaulois {
	private String nom;
	private int effetPotion = 1;
	private int force;
	private int nb_trophees;
	private Equipement[] trophees = new Equipement[100];

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
//		romain.recevoirCoup((force / 3)*effetPotion);
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] lTrophees = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; lTrophees != null && i < lTrophees.length; i++,nb_trophees++) {
			this.trophees[nb_trophees] = lTrophees[i];
		}
	}


	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
		this.parler("Merci Druide je sens que ma force est " + forcePotion + " fois décuplée.");
	}
	
	public void faireUneDonation(Musee musee) {
		if(this.trophees != null && this.nb_trophees > 0) {
			String texte = "Je donne au musee tous mes trophees : \n";
			System.out.println(Arrays.toString(this.trophees));
			System.out.println(this.nb_trophees);
			for(int i = 0; i < this.nb_trophees; i++) { //Equipement equi : this.trophees
				musee.donnerTrophees(this, this.trophees[i]);
				texte += "- " + this.trophees[i].toString() + "\n";
			}
			this.parler(texte);
		}
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix",8);
		System.out.println(asterix);
		System.out.println(asterix.prendreParole());
		asterix.parler("Je test de parler");
		Romain testRomain = new Romain("testRomain",1);
		asterix.frapper(testRomain);
		asterix.boirePotion(5);
		asterix.frapper(testRomain);
	}

}
