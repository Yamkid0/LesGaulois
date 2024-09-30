package personnages;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophee = 0;
	
	public void donnerTrophees(Gaulois gaulois,Equipement equipement) {
		if(nbTrophee+1 < 200) {
			Trophee trophee = new Trophee(gaulois, equipement);
			trophees[nbTrophee] = trophee;
			nbTrophee++;
		} else {
			System.out.println("Musée déjà plein");
		}
	}
	
	public String extraireInstructionsOCaml() {
		String texte = "let musee = [\n";
		for(int i = 0; i< nbTrophee; i++) {
			texte +="\t\"" +  trophees[i].getGaulois().getNom() + "\", \"" + trophees[i].getEquipement().toString() + "\"";
			
			if(i+1 != nbTrophee) {
				texte +=";";
			}
			texte+="\n";
		}
		texte+= "]";
		return texte;
	}
}
