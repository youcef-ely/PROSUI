package com.utilisateurs;

import java.util.List;

import com.projet.Document;
import com.projet.Planning;
import com.projet.Projet;

public interface iAdministrateur {
public int creerCompte(String nom, String prenom, String email, long telephone,String MotDePasse);
public int creerCompte(Administrateur admin);
public int ajouterCDP(String nom, String prenom, String email, long telephone,String MotDePasse,int idProjet);
public int ajouterCDP(ChefDeProjet chef);
public  int supprimerMonCompte(int id);
public Administrateur findadmin(int id);
public List<Administrateur> allAdmins();
public List<ChefDeProjet> consulterCDPs(int idAdmin);
public ChefDeProjet consuletrCDP(int id);
public ChefDeProjet findchef(int id);
public int mettreajour(int id, Administrateur ad);
public int modifierCDP(ChefDeProjet chef);
public  int supprimerCDP(int id);
public List<Projet> consulterMesProjets(int idAdmin);
public int ajouterProjet(String titreProjet, String typeProjet, byte[] descriptionProjet,String filename,String etatProjet,String datelimite, int idCDP, int idAdmin);
public int ajouterProjet(Projet projet);
public int modifierProjet( Projet projet);
public Projet consulterProjet(int idAdmin);
public  int supprimerProjet(int id);
public Administrateur seconnecter(String gmail, String password);
public List<Document> consulterdocs(int idprojet);
public List<Planning> consulterplanning(int idprojet);
List<ChefDeProjet> consulterCDPsDansProjet(int id);
public Integer getNombreEtatenpause(int id);
public Integer getNombreEtattermine(int id);
public Integer getNombreEtatencours(int id);
public Integer getNombreProjet(int id);
public Integer getNombreDocument(int id);
public Integer getNombreEtatdebut(int id);
public Integer getNombreChefProjet(int id);


}
