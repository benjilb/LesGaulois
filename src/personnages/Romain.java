package personnages;

public class Romain {
	private String nom;
	private int force;
	public int getForce() {
		return force;
	}

	private int nbEquipementMax = 2;
	private int nbEquipement = 0;
	private Equipement[] equipements;
	

	
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[nbEquipementMax];
		assert force >= 0;
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
	
	
//	public void recevoirCoup(int forcecoup) {
//		force -= forcecoup;
//		if (force > 0) {
//			parler("Aie");
//	} else {
//		parler("J'abandonne...");
//			
//		}
//		
//	}
	public Equipement[] recevoirCoup(int forceCoup) {
		
		Equipement[] equipementEjecte = null;
		// precondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		// if (force > 0) {
		// parler("A�e");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		if (force > 0) {
			parler("Aie");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		// post condition la force a diminuer
		assert force < oldForce;
		return equipementEjecte;
	}
	
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace a mon equipement sa force est diminue de ";
			for (int i = 0; i < nbEquipement; i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.Bouclier))) {
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
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'equipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			} 
		}
		return equipementEjecte;
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
				
			} else {
				equipements[1] = equipement;
				nbEquipement++;
				System.out.println("Le soldat " + nom + " s'equipe avec un " + equipements[1] + " .");
			}
			break;
		}
		default : {
			equipements[0] = equipement;
			nbEquipement++;
			System.out.println("Le soldat " + nom + " s'equipe avec un " + equipements[0] + " .");
		}
		}	
	} 
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
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
