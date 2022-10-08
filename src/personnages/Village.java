package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	
	
	public Village(String nom, int nbVillageoisMaximum) {
		super();
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMaximum];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public String getNom() {
		return nom;
	}
	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois]= gaulois;
		nbVillageois++;	
	}
	
	public Gaulois trouverHabitant(int iVillageois) {
		return villageois[iVillageois];
		
	}
	public void afficherVillageois() {
		System.out.println("Dans le village du chef " + chef.getNom() + " vivent les légendaires gaulois :");
		for(int i=0; i < nbVillageois; i++) {
			System.out.println("- " + villageois[i].getNom());
		}
		
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des irreductibles", 30);
//		Gaulois gaulois = village.trouverHabitant(30);
//		car 30 n'est pas dans le tableau 0 a 29 uniquement
		Chef abraracourcix = new Chef("Abraracourcix", 6, 1, village);
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Asterix", 8);
		village.ajouterHabitant(asterix);
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
//  	on obtient null car il n'y a pas 2 villageois,
//		il y a uniquement asterix
		
		Gaulois obelix = new Gaulois("Obelix", 25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
		
		
	}
	
}
