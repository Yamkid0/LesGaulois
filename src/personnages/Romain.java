package personnages;

public class Romain {
	

	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	private boolean vainqueur = false;

	public Romain(String nom, int force) {
		assert force > 0;
		this.nom = nom;
		this.force = force;
	}
	
	public boolean isVainqueur() {
		return vainqueur;
	}

	public int getForce() {
		return force;
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

	private void soldatSequipe(Equipement equipement) {
		this.nbEquipement++;
		System.out.println("Le soldat " + this.nom + " s'équipe avec un " + equipement);
	}

	public void sEquiper(Equipement equipement) {
		switch (this.nbEquipement) {
		case 0:
			this.equipements[0] = equipement;
			this.soldatSequipe(equipement);
			break;
		case 1:
			if (this.equipements[0] == equipement) {
				System.out.println("Le soldat " + this.nom + " possède déjà un " + equipement);
			} else {
				this.equipements[1] = equipement;
				this.soldatSequipe(equipement);
			}
			break;
		default: // 2
			System.out.println("Le soldat " + this.nom + " est déjà bien protégé ! ");
		}
	}

//	public void recevoirCoup(int forceCoup) {
//		assert force > 0;
//		int initForce = force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aïe");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert force < initForce;
//	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		// if (force > 0) {
		// parler("Aïe");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		if (force == 0) {
			parler("Aïe");
			
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		
		//Si équipement supérieur à la force du coup ne perd pas forcément de la force
		
		if(force == oldForce) {
			parler("Mon équipement m'a protégé.");
		}
		
		if(force <= 0) {
			vainqueur = true;
		}
		// post condition la force a diminuée ou equipement a protégée
		assert force <= oldForce;
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) {
				if ((equipements[i] != null &&
					equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		if(forceCoup < 0) {
			forceCoup = 0;
		}
		return forceCoup;
	}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		nbEquipement = 0;
		return equipementEjecte;
	}

	public static void main(String[] args) {
		Romain romain = new Romain("Minus", 1);
		// System.out.println(romain.prendreParole());
		romain.parler("Le romain parle");
		romain.recevoirCoup(1);
		try {
			romain.recevoirCoup(1);
		} catch (AssertionError err) {
			System.out.println(err);
		}

//		System.out.println(Equipment.BOUCLIER);
//		System.out.println(Equipment.CASQUE);

		romain.sEquiper(Equipement.CASQUE);
		romain.sEquiper(Equipement.CASQUE);
		romain.sEquiper(Equipement.BOUCLIER);
		romain.sEquiper(Equipement.BOUCLIER);
		romain.sEquiper(Equipement.CASQUE);

	}
}
