package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int nb_trophees;
	private int effetPotion = 1;
	private Equipement[] trophees = new Equipement[100];
	
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte){
		System.out.println(prendreParole() + "< " + texte + " >");
	}
	
//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//		
//	}
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la machoire de " 
//				+ romain.getNom());
//		romain.recevoirCoup(force/3 * effetPotion);
//	}
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] newtrophees = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; newtrophees != null && i < newtrophees.length; i++, nb_trophees++) {
			this.trophees[nb_trophees] = newtrophees[i];
		}
	}

	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + effetPotion  + " fois decuplee.");
	}
	
	

		
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		System.out.println(asterix.getNom());
		System.out.println(asterix.prendreParole());
		asterix.parler("je suis Asterix");
		System.out.println(asterix);
		asterix.boirePotion(4);
	}
}
