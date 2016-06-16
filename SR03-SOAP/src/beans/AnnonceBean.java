package beans;

public class AnnonceBean {
	

	private int id;
	private String annonceur;
	private String nom;
	private String tel;
	private AdresseBean adresse;
	private String details;
	
	public int getId() {	return id;	}
	public void setId(int id) {	this.id = id;	}
	
	
	public String getAnnonceur() {	return annonceur; }
	public void setAnnonceur(String annonceur) { this.annonceur = annonceur;}
	
	public String getNom() { return nom; }
	public void setNom(String nom) {this.nom = nom;	}
	
	public String getTel() { return tel; }
	public void setTel(String tel) { this.tel = tel;}
	
	public AdresseBean getAdresse() {	return adresse; 	}
	public void setAdresse(AdresseBean adresse) {	this.adresse = adresse;	}
	
	public String getDetails() {  return details;	}
	public void setDetails(String details) {	this.details = details;	}

}
