package com.utilisateurs;


public abstract class  Utilisateur {

protected int idutilisateur;
protected String nom;
protected String prenom;
protected String email;
protected long telephone;
protected String dateinscription;
protected String MotDePasse;
public Utilisateur() {
	super();
}
public Utilisateur(String nom, String prenom, String email, long telephone, String dateinscription, String MotDePasse) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.telephone = telephone;
	this.dateinscription = dateinscription;
	this.MotDePasse = MotDePasse;
}public Utilisateur(int idutilisateur,String nom, String prenom, String email, long telephone, String dateinscription, String MotDePasse) {
	super();
	this.idutilisateur = idutilisateur;
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.telephone = telephone;
	this.dateinscription = dateinscription;
	this.MotDePasse = MotDePasse;
}

public Utilisateur(Utilisateur us) {
	super();
	this.nom = us.nom;
	this.prenom = us.prenom;
	this.email = us.email;
	this.telephone = us.telephone;
	this.dateinscription = us.dateinscription;
	this.MotDePasse = us.MotDePasse;
}
public Utilisateur(String nom2, String prenom2, String email2, long tel, String mdp) {
	super();
	this.nom = nom2;
	this.prenom = prenom2;
	this.email = email2;
	this.telephone = tel;
	this.MotDePasse = mdp;
}
public Utilisateur(int idchef, String nom2, String prenom2, String email2, long tel, String mdp) {
this.idutilisateur=idchef;
this.nom=nom2;
this.prenom=prenom2;
this.email=email2;
this.telephone=tel;
this.MotDePasse=mdp;
}
public int getIdutilisateur() {
	return idutilisateur;
}
public String getMotDePasse() {
	return MotDePasse;
}
public void setMotDePasse(String motDePasse) {
	MotDePasse = motDePasse;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public long getTelephone() {
	return telephone;
}
public void setTelephone(long telephone) {
	this.telephone = telephone;
}
public String getDateinscription() {
	return dateinscription;
}
public void setDateinscription(String dateinscription) {
	this.dateinscription = dateinscription;
}

}