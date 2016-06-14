/**
 * 
 */
package beans;

import java.util.ArrayList;

/**
 * @author Xavier
 *
 */
public class Annonce {

	private int id;
	private String annonceur;
	private String nom;
	private String tel;
	private int idAddr;
	private ArrayList<Annonce> annonces;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnnonceur() {
		return annonceur;
	}
	public void setAnnonceur(String annonceur) {
		this.annonceur = annonceur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getIdAddr() {
		return idAddr;
	}
	public void setIdAddr(int idAddr) {
		this.idAddr = idAddr;
	}
	public ArrayList<Annonce> getAnnonces() {
		return annonces;
	}
	public void setAnnonces(ArrayList<Annonce> annonces) {
		this.annonces = annonces;
	}
	
	
}
