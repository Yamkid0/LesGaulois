package histoire;

import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;

public class SaveScenario {

	public static void main(String[] args) {
		//inits
		Gaulois asterix = new Gaulois("Ast�rix",8);
		Gaulois obelix = new Gaulois("Ob�lix",25);
		Druide panoramix = new Druide("Panoramix",5,10);
		
		Romain minus = new Romain("Minus",6);
		
		//scenario
		panoramix.parler("Je vais aller pr�parer une petite potion...");
		panoramix.preparerPotion();
		panoramix.booster(obelix);
		obelix.parler("Par B�n�los, ce n'est pas juste !");
		panoramix.booster(asterix);
		asterix.parler("Bonjour");
		minus.parler("UN GAU... UN GAUGAU...");
		asterix.frapper(minus);
	}

}
