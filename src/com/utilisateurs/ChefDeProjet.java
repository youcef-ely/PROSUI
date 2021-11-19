package com.utilisateurs;
import com.projet.*;

import java.util.ArrayList;
import java.util.List;

public class ChefDeProjet extends Utilisateur {
protected int idAdmin;

protected List<Document> Documents = new ArrayList<Document>();
public ChefDeProjet(String nom, String prenom, String email, long telephone, String dateinscription, String MotDePasse, int idAdmin) {
	super(nom,prenom,email,telephone,dateinscription,MotDePasse);
	this.idAdmin=idAdmin;
}
public ChefDeProjet(int idutilisteur, String nom, String prenom, String email, long telephone, String dateinscription, String MotDePasse, int idAdmin) {
	super(idutilisteur,nom,prenom,email,telephone,dateinscription,MotDePasse);
	this.idAdmin=idAdmin;
}
public ChefDeProjet(ChefDeProjet chef) {
	super(chef.nom,chef.prenom,chef.email,chef.telephone,chef.dateinscription,chef.MotDePasse);
	this.idAdmin=chef.idAdmin;
	}
public ChefDeProjet(String nom, String prenom, String email, long tel, String mdp) {
	super(nom, prenom, email,  tel, mdp);
}

public ChefDeProjet(int idchef, String nom, String prenom, String email, long tel, String mdp) {
	super(idchef,nom,prenom,email,tel,mdp);
}
public List<Document> getDocuments() {
	return Documents;
}
public void setDocuments(List<Document> Documents) {
	this.Documents = Documents;
}
@Override
public String toString() {
	return"Id: "+idutilisateur+" Nom:"+ nom+" Prenom: "+prenom+" Email: "+email+"  Telephone: "+telephone+" Date inscription: "+dateinscription+" Administrateur: "+idAdmin;
}

public int getIdAdmin() {
	return idAdmin;
}

public void setIdAdmin(int idAdmin) {
	this.idAdmin = idAdmin;
}

}
