/**
 * Annuaire.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package DAO;

public interface Annuaire extends java.rmi.Remote {
    public beans.CategorieBean[] getCategories() throws java.rmi.RemoteException;
    public void addAdresse(beans.AdresseBean b) throws java.rmi.RemoteException;
    public beans.AdresseBean getAdresse(int idAdresse) throws java.rmi.RemoteException;
    public beans.AnnonceBean[] getAnnonces() throws java.rmi.RemoteException;
    public void deleteAnnonce(int id) throws java.rmi.RemoteException;
    public void addAnnonce(beans.AnnonceBean a, beans.CategorieBean b) throws java.rmi.RemoteException;
    public void deleteCategorie(int id) throws java.rmi.RemoteException;
    public void addCategorie(java.lang.String nom) throws java.rmi.RemoteException;
    public beans.AnnonceBean[] getAnnoncesWithId(int id) throws java.rmi.RemoteException;
    public void updateAnnonceName(beans.AnnonceBean annonce) throws java.rmi.RemoteException;
    public beans.AnnonceBean[] getAnnoncesWithIdCateg(int id) throws java.rmi.RemoteException;
    public void updateCategorieName(int id, java.lang.String newName) throws java.rmi.RemoteException;
}
