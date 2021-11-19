package com.projet;

public class Planning {
	private int idtache;
	private String tache;
	private String datedebut;
	private String datefin;
	private int idprojet;
	
	
	
	
	public Planning(int idtache, String tache, String datedebut, String datefin, int idprojet) {
		super();
		this.idtache = idtache;
		this.tache = tache;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.idprojet = idprojet;
	}
	
	
	public String getDatedebut() {
		return datedebut;
	}


	public void setDatedebut(String datedebut) {
		this.datedebut = datedebut;
	}


	public String getDatefin() {
		return datefin;
	}


	public void setDatefin(String datefin) {
		this.datefin = datefin;
	}


	public int getIdtache() {
		return idtache;
	}
	public void setIdtache(int idtache) {
		this.idtache = idtache;
	}
	public String getTache() {
		return tache;
	}
	public void setTache(String tache) {
		this.tache = tache;
	}
	public int getIdprojet() {
		return idprojet;
	}
	public void setIdprojet(int idprojet) {
		this.idprojet = idprojet;
	}
	
	

}
