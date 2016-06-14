package beans;

import java.util.ArrayList;

public class CategorieBean {

	private int id;
	private String nom;
	private AnnonceBean[] anonces;
	
	public int getId() { return id;	}
	public void setId(int id) {	this.id = id;	}
	
	public String getNom() { return nom;	}
	public void setNom(String nom) {	this.nom = nom;	}
	
	public AnnonceBean[] getAnonces() { return anonces;	}
	public void setAnonces(AnnonceBean[] anonces) {
		this.anonces = anonces;
	}
	
	
}
