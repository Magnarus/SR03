/**
 * 
 */
package beans;

import java.util.ArrayList;

/**
 * @author Xavier
 *
 */
public class Categorie {
	
	private int id;
	private String nom;
	private ArrayList<Categorie> categories;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public ArrayList<Categorie> getAnnonces() {
		return categories;
	}
	public void setAnnonces(ArrayList<Categorie> cat) {
		this.categories = cat;
	}
	
	public void addCategorie(Categorie cat){
		categories.add(cat);
	}
	public void removeCategorie(Categorie cat){
		categories.remove(cat);
	}
	
	

}
