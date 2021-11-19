package com.projet;

public class Document {
private int idDocument;
private String descriptiondoc;
private byte[] document;
protected String filename;
private int idProjet;







public Document(int idDocument, String descriptiondoc,byte[] document, String filename, int idProjet) {
	super();
	this.idDocument = idDocument;
	this.descriptiondoc = descriptiondoc;
	this.document = document;
	this.filename = filename;
	this.idProjet = idProjet;
}


public int getIdDocument() {
	return idDocument;
}
public void setIdDocument(int idDocument) {
	this.idDocument = idDocument;
}
public int getIdProjet() {
	return idProjet;
}
public void setIdProjet(int idProjet) {
	this.idProjet = idProjet;
}
public String getDescriptiondoc() {
	return descriptiondoc;
}
public void setDescriptiondoc(String descriptiondoc) {
	this.descriptiondoc = descriptiondoc;
}
public String getFilename() {
	return filename;
}
public void setFilename(String filename) {
	this.filename = filename;
}


public byte[] getDocument() {
	return document;
}


public void setDocument(byte[] document) {
	this.document = document;
}





}
