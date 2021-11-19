package com.utilisateurs;

import java.util.List;

import com.projet.Document;
import com.projet.Planning;
import com.projet.Projet;

public interface iChefDeProjet {
public ChefDeProjet seconnecter(String gmail, String password);
public int modifierchef (int id,String mdp);
public Projet monprojet(int id);
public List<Document> consulterdocs(int idprojet);
public int ajouterdoc(String Descriptiondoc, byte[] Document, String Filename, int IdProjet);
public int supprimerdoc(int id);
public int ajoutertache(String tache,String datedebut, String datefin, int idprojet);
public int modifiertache(int id, String nvtache,String nvdatedebut,String nvdatefin);
public int supprimertache(int idtache);
public List<Planning> consultermonplanning(int idprojet);
public Planning findtache(int idtache);

}
