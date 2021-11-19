package com.utilisateurs;

import java.util.ArrayList;
import java.util.List;

import com.projet.Projet;


public class Administrateur extends Utilisateur {
protected List<Projet> Projets = new ArrayList<Projet>();
protected List<ChefDeProjet> Les_chefs = new ArrayList<ChefDeProjet>();

public Administrateur(String nom, String prenom, String email, long telephone, String dateinscription,String MotDePasse) {
		super(nom, prenom, email, telephone, dateinscription,MotDePasse);
		// TODO Auto-generated constructor stub
}

public Administrateur(int id, String nom, String prenom, String email, long telephone, String dateinscription,String MotDePasse) {
	super(id,nom, prenom, email, telephone, dateinscription,MotDePasse);
	// TODO Auto-generated constructor stub
}

	public Administrateur(Administrateur ad) {
		super(ad);
		// TODO Auto-generated constructor stub
	}

	public Administrateur(String nom, String prenom, String email, long tel, String mdp) {
		super(nom, prenom, email, tel,mdp);

	}

	public List<Projet> getProjets() {
		return Projets;
	}

	public void setProjets(List<Projet> projets) {
		Projets = projets;
	}

	public List<ChefDeProjet> getLes_chefs() {
		return Les_chefs;
	}

	public void setLes_chefs(List<ChefDeProjet> les_chefs) {
		Les_chefs = les_chefs;
	}
@Override
public String toString() {
	return"Nom:"+ nom+" Prenom: "+prenom+" Email: "+email+"  Telephone: "+telephone+" Date inscription: "+dateinscription;
}
}
