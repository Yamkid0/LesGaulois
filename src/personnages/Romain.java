package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipment[] equipements = new Equipment[2];
	private int nbEquipment = 0;

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
	
	private void soldatSequipe(Equipment equipement) {
		this.nbEquipment++;
		System.out.println("Le soldat " + this.nom + " s'équipe avec un " + equipement);
	}
	
	private void sEquiper(Equipment equipement) {
		switch(this.nbEquipment) {
			case 0:
				this.equipements[0] = equipement;
				this.soldatSequipe(equipement);
				break;
			case 1:
				if(this.equipements[0] == equipement ) {
					System.out.println("Le soldat " + this.nom + " possède déjà un " + equipement);
				} else {
					this.equipements[1] = equipement;
					this.soldatSequipe(equipement);
				}
				break;
			default: //2
				System.out.println("Le soldat " + this.nom + " est déjà bien protégé ! ");
		}
	}

	public void recevoirCoup(int forceCoup) {
		assert force > 0;
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
		try {
			romain.recevoirCoup(1);
		} catch(AssertionError err) {
			System.out.println(err);
		}
		
		
//		System.out.println(Equipment.BOUCLIER);
//		System.out.println(Equipment.CASQUE);
		
		romain.sEquiper(Equipment.CASQUE);
		romain.sEquiper(Equipment.CASQUE);
		romain.sEquiper(Equipment.BOUCLIER);
		romain.sEquiper(Equipment.BOUCLIER);
		romain.sEquiper(Equipment.CASQUE);
		
		
	}
}
