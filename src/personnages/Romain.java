package personnages;

public class Romain {
	private String nom;
	private int force;
	private int nbEquipementMax = 2;
	private int nbEquipement = 0;
	private Equipement[] equipements;
	
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[nbEquipementMax];
	}


	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "< " + texte + " >");
		
	}
	private String prendreParole() {
		return "Le romain " + nom + " : ";	
	}
	
	
	public void recevoirCoup(int forcecoup) {
		force -= forcecoup;
		if (force > 0) {
			parler("Aie");
	} else {
		parler("J'abandonne...");
			
		}
		
	}
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2: {
			System.out.println("Le soldat " + nom + " est deja bien protege ! ");
			break;
		}
		case 1: {
			if (equipements[0] == equipement ) {
				System.out.println("Le soldat " + nom + " possede deja un " + equipements[0] + " !" );
				break;
			} else {
				equipements[1] = equipement;
				nbEquipement++;
				System.out.println("Le soldat " + nom + " s'equipe avec un " + equipements[1] + " .");
			}
		}
		default : {
			equipements[0] = equipement;
			nbEquipement++;
			System.out.println("Le soldat " + nom + " s'equipe avec un " + equipements[0] + " .");
		}
		}	
	} 
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", -6);
//		System.out.println(minus.prendreParole());
//		minus.parler("bonjour");
//		minus.recevoirCoup(4);
//		minus.recevoirCoup(3);
//		System.out.println(Equipement.Casque);
//		System.out.println(Equipement.Bouclier);
		minus.sEquiper(Equipement.Casque);
		minus.sEquiper(Equipement.Casque);
		minus.sEquiper(Equipement.Bouclier);
		minus.sEquiper(Equipement.Casque);
	}
}
