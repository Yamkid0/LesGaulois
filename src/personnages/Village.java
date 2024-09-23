package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private int nbVillageois = 0;
	private Gaulois[] villageois;
	private int nbVillageoisMaximum;
	
	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.nbVillageoisMaximum = nbVillageoisMaximum;
		this.villageois = new Gaulois[this.nbVillageoisMaximum];
	}

	public void setChef(Chef chef) {
		this.chef = chef;
		
	}

	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		if(nbVillageois+1 > this.nbVillageoisMaximum) {
			System.out.println("NOMBRE MAXIMAL ATTEINT");
		} else {
			this.villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}
	}
	
	public Gaulois trouverHabitant(int numeroVillageois) {
		return villageois[numeroVillageois-1];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village du chef " + chef.getNom() + " vivent les légendaires gaulois : ");
		for(int i = 0; i < nbVillageois; i ++) {
			System.out.println(" - " + this.villageois[i].getNom());
		}
	}

	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles",30);
		//Gaulois gaulois = village.trouverHabitant(30); 
		// Out of bounds essaye d'obtenir une valeur du tableau non définie
		
		Chef abraracourcix = new Chef("Abraracourcix",6,village);
		village.setChef(abraracourcix);
		
		Gaulois asterix = new Gaulois("Astérix",8);
		village.ajouterHabitant(asterix);
		
		Gaulois obelix = new Gaulois("Obélix",25);
		village.ajouterHabitant(obelix);
		
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
		// affiche le to string du gaulois
		
		village.afficherVillageois();
		
	}
}
