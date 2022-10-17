package personnages;

public enum Equipement {
	Casque("casque"), Bouclier("bouclier");
	private String nom;

	private Equipement(String nom) {
		this.nom = nom;
	}
	@Override
	public String toString() {
		if (nom == "casque") {
			return "Equipement [Casque=" + Casque.nom + "]";
		}else {
			return "Equipement [Bouclier=" + Bouclier.nom + "]";
		}
//		return "Equipement [Casque=" + Equipement.Casque + ", Bouclier=" + Equipement.Bouclier + "]";
	}
}
