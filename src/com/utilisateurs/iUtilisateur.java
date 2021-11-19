package com.utilisateurs;

public interface iUtilisateur  {
public int creerCompte(Utilisateur us);
public int creerCompte(String nom, String prenom, String email, long telephone, String dateinscription);
public int supprimerMonCompte(int id);
}
