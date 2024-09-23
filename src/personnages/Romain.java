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
		System.out.println(prendreParole() + "� " + texte + "�");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	private void soldatSequipe(Equipment equipement) {
		System.out.println("Le soldat " + this.nom + " s'�quipe avec un " + equipement);
	}
	
	private void sequiper(Equipment equipement) {
		switch(this.nbEquipment) {
			case 0:
				this.equipements[0] = equipement;
				this.nbEquipment++;
				this.soldatSequipe(equipement);
				break;
			case 1:
				if(this.equipements[0] == equipement ) {
					System.out.println("Le soldat " + this.nom + " poss�de d�j� un " + equipement);
				} else {
					this.equipements[1] = equipement;
					this.nbEquipment++;
					this.soldatSequipe(equipement);
				}
				break;
			default: //2
				System.out.println("Le soldat " + this.nom + " est d�j� bien prot�g� ! ");
		}
	}

	public void recevoirCoup(int forceCoup) {
		assert force >= 0;
		int initForce = force;
		force -= forceCoup;
		if (force > 0) {
			parler("A�e");
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
		
		System.out.println(Equipment.BOUCLIER);
		System.out.println(Equipment.CASQUE);
		
		romain.sequiper(Equipment.CASQUE);
		romain.sequiper(Equipment.CASQUE);
		romain.sequiper(Equipment.BOUCLIER);
		romain.sequiper(Equipment.BOUCLIER);
		
		
	}
}
