package personnages;

public enum Equipment {
	CASQUE("casque"),BOUCLIER("bouclier");
	
	private String nom;
	
	private Equipment(String nom) {
		this.nom = nom;
	}
	
	@Override
	public String toString() {
		return this.nom;
	}
}
