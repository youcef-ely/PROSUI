package com.projet;

public class Projet {
protected int idProjet;
protected String titreProjet;
protected String typeProjet;
protected byte[] descriptionProjet;
protected String etatProjet;
protected String datelimite;
protected int idCDP;
protected int idAdmin;
protected String filename;
public Projet(int idProjet, String titreProjet, String typeProjet, byte[] descriptionProjet, String etatProjet,
		String datelimite) {
	super();
	this.idProjet = idProjet;
	this.titreProjet = titreProjet;
	this.typeProjet = typeProjet;
	this.descriptionProjet = descriptionProjet;
	this.etatProjet = etatProjet;
	this.datelimite = datelimite;
}

public Projet(int idProjet, String titreProjet, String typeProjet, byte[] descriptionProjet, String etatProjet,
		String datelimite, int idCDP, int idAdmin,String filename) {
	super();
	this.idProjet = idProjet;
	this.titreProjet = titreProjet;
	this.typeProjet = typeProjet;
	this.descriptionProjet = descriptionProjet;
	this.etatProjet = etatProjet;
	this.datelimite = datelimite;
	this.idCDP = idCDP;
	this.idAdmin = idAdmin;
	this.filename=filename;
}

public Projet(int idProjet, String titreProjet, String typeProjet, byte[] descriptionProjet, String etatProjet,
		String datelimite, int idCDP, int idAdmin) {
	super();
	this.idProjet = idProjet;
	this.titreProjet = titreProjet;
	this.typeProjet = typeProjet;
	this.descriptionProjet = descriptionProjet;
	this.etatProjet = etatProjet;
	this.datelimite = datelimite;
	this.idCDP = idCDP;
	this.idAdmin = idAdmin;
}
public Projet(String titreProjet, String typeProjet, byte[] descriptionProjet, String etatProjet,String datelimite, int idCDP, int idAdmin) {
	super();
	this.titreProjet = titreProjet;
	this.typeProjet = typeProjet;
	this.descriptionProjet = descriptionProjet;
	this.etatProjet = etatProjet;
	this.idCDP = idCDP;
	this.idAdmin=idAdmin;
	this.datelimite=datelimite;
}
public Projet(Projet projet) {
	this.titreProjet = projet.titreProjet;
	this.typeProjet = projet.typeProjet;
	this.descriptionProjet = projet.descriptionProjet;
	this.etatProjet = projet.etatProjet;
	this.datelimite=projet.datelimite;
	this.idCDP = projet.idCDP;
	this.idAdmin = projet.idAdmin;
}
public Projet(int idprojet2, String titre, String type, byte[] fileupload, String etat, String datelimite2,int idutilisateur,String filename) {
	this.idProjet=idprojet2;
	this.titreProjet = titre;
	this.typeProjet = type;
	this.descriptionProjet = fileupload;
	this.etatProjet = etat;
	this.datelimite = datelimite2;
	this.idCDP=idutilisateur;
	this.filename=filename;
}

public String getFilename() {
	return filename;
}
public void setFilename(String filename) {
	this.filename = filename;
}
public String getDatelimite() {
	return datelimite;
}
public void setDatelimite(String datelimite) {
	this.datelimite = datelimite;
}
public int getIdProjet() {
	return idProjet;
}
public String getTitreProjet() {
	return titreProjet;
}
public void setTitreProjet(String titreProjet) {
	this.titreProjet = titreProjet;
}
public String getTypeProjet() {
	return typeProjet;
}
public void setTypeProjet(String typeProjet) {
	this.typeProjet = typeProjet;
}
public byte[] getDescriptionProjet() {
	return descriptionProjet;
}
public void setDescriptionProjet(byte[] descriptionProjet) {
	this.descriptionProjet = descriptionProjet;
}

public String getEtatProjet() {
	return etatProjet;
}
public void setEtatProjet(String etatProjet) {
	this.etatProjet = etatProjet;
}
public int getIdCDP() {
	return idCDP;
}

public int getIdAdmin() {
	return idAdmin;
}
public void setIdAdmin(int idAdmin) {
	this.idAdmin = idAdmin;
}
public void setIdProjet(int idProjet) {
	this.idProjet = idProjet;
}
public void setIdCDP(int idCDP) {
	this.idCDP = idCDP;
}

}
