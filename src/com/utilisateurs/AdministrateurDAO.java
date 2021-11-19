package com.utilisateurs;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.projet.Document;
import com.projet.Planning;
import com.projet.Projet;
import com.util.Connection;

public class AdministrateurDAO implements iAdministrateur {
	@Override
	public int creerCompte(String nom, String prenom, String email, long telephone, String MotDePasse) {
		// TODO Auto-generated method stub
		int nb;
		Connection.connect();
		nb = Connection.miseajour("insert into administrateur (nom,prenom,email,telephone,motdepasse) " + "values('"
				+ nom + "','" + prenom + "','" + email + "'," + telephone + ",'" + MotDePasse + "')");
		Connection.disconnect();
		return nb;
	}

	@Override
	public int creerCompte(Administrateur admin) {
		// TODO Auto-generated method stub
		int nb;
		Connection.connect();
		nb = Connection.miseajour("insert into administrateur values(null,'" + admin.getNom() + "','"
				+ admin.getPrenom() + "','" + admin.getEmail() + "'," + admin.getTelephone() + ",'"
				+ admin.getDateinscription() + "','" + admin.getMotDePasse() + "')");
		Connection.disconnect();
		return nb;
	}

	@Override
	public int supprimerMonCompte(int id) {
		// TODO Auto-generated method stub
		int nb;
		Connection.connect();
		nb = Connection.miseajour("delete from Administrateur where idAdmin in ('" + id + "')");
		Connection.disconnect();
		return nb;
	}

	@Override
	public Administrateur findadmin(int id) {
		// TODO Auto-generated method stub
		Administrateur admin = null;
		Connection.connect();
		ResultSet rs = Connection.select("select * from Administrateur where idadmin=" + id);
		try {
			if (rs.next())
				admin = new Administrateur(rs.getString("nom"), rs.getString("prenom"), rs.getString("email"),
						rs.getLong("telephone"), rs.getString("dateinscription"), rs.getString("MotDePasse"));

		} catch (SQLException s) {
			// TODO Auto-generated catch block
			s.printStackTrace();
		}
		Connection.disconnect();
		return admin;
	}

	@Override
	public int ajouterCDP(String nom, String prenom, String email, long telephone, String MotDePasse, int idAdmin) {
		// TODO Auto-generated method stub
		int nb;
		Connection.connect();
		nb = Connection.miseajour("insert into ChefDeProjet (nom,prenom,email,telephone,motdepasse,idadmin) values('"
				+ nom + "','" + prenom + "','" + email + "'," + telephone + ",'" + MotDePasse + "'," + idAdmin + ")");
		Connection.disconnect();
		return nb;
	}

	@Override
	public int ajouterCDP(ChefDeProjet chef) {
		// TODO Auto-generated method stub
		int nb;
		Connection.connect();
		nb = Connection.miseajour("insert into ChefDeProjet values(null,'" + chef.getNom() + "','" + chef.getPrenom()
				+ "','" + chef.getEmail() + "'," + chef.getTelephone() + ",'" + chef.getDateinscription() + "','"
				+ chef.getMotDePasse() + "'," + chef.getIdAdmin() + ")");
		Connection.disconnect();
		return nb;
	}

	@Override
	public List<ChefDeProjet> consulterCDPs(int id) {

		List<ChefDeProjet> Chefs = new ArrayList<ChefDeProjet>();
		ChefDeProjet c = null;
		Connection.connect();
		ResultSet rs = Connection.select("select * from chefdeprojet where idAdmin=" + id);
		try {
			while (rs.next()) {
				c = new ChefDeProjet(rs.getInt("idCDP"), rs.getString("Nom"), rs.getString("Prenom"),
						rs.getString("email"), rs.getLong("telephone"), rs.getString("dateinscription"),
						rs.getString("motdepasse"), rs.getInt("idAdmin"));
				Chefs.add(c);
			}

		} catch (SQLException s) {
			// TODO Auto-generated catch block
			s.printStackTrace();
		}
		return Chefs;
	}

	public ChefDeProjet consuletrCDPparnom(String nom, String prenom) {
		// TODO Auto-generated method stub
		ChefDeProjet chef = null;
		Connection.connect();
		ResultSet rs = Connection
				.select("select * from ChefDeProjet where nom='" + nom + "' and prenom='" + prenom + "'");
		try {
			if (rs.next())
				chef = new ChefDeProjet(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getLong(5),
						rs.getString(6), rs.getString(7), rs.getInt(8));
		} catch (SQLException s) {
			// TODO Auto-generated catch block
			s.printStackTrace();
		}
		Connection.disconnect();
		return chef;
	}

	@Override
	public ChefDeProjet consuletrCDP(int id) {
		// TODO Auto-generated method stub
		ChefDeProjet chef = null;
		Connection.connect();
		ResultSet rs = Connection.select("select * from ChefDeProjet where idCDP=" + id);
		try {
			if (rs.next())
				chef = new ChefDeProjet(rs.getInt("idCDP"), rs.getString("nom"), rs.getString("prenom"),
						rs.getString("email"), rs.getLong("telephone"), rs.getString("dateinscription"),
						rs.getString("MotDePasse"), rs.getInt("idAmin"));

		} catch (SQLException s) {
			// TODO Auto-generated catch block
			s.printStackTrace();
		}
		Connection.disconnect();
		return chef;
	}

	@Override
	public int modifierCDP( ChefDeProjet chef) {
		// TODO Auto-generated method stub
		int nb = 0;
		Connection.connect();
		nb = Connection.miseajour("UPDATE ChefDeProjet set nom = '" + chef.getNom() + "', prenom = '" + chef.getPrenom()+ "',email = '" + chef.getEmail() + "',telephone = " +chef.getTelephone()+ ",MotDePasse = '"+ chef.getMotDePasse() + "' where idCDP =" + chef.getIdutilisateur());
		Connection.disconnect();
		return nb;
	}

	@Override
	public int supprimerCDP(int id) {
		// TODO Auto-generated method stub
		int nb;
		Connection.connect();
		nb = Connection.miseajour("delete from ChefDeProjet where idCDP in ('" + id + "')");
		Connection.disconnect();
		return nb;
	}

	@Override
	public List<Administrateur> allAdmins() {
		// TODO Auto-generated method stub
		List<Administrateur> Admins = new ArrayList<Administrateur>();
		Administrateur admin = null;
		Connection.connect();
		ResultSet rs = Connection.select("select * from Administrateur");
		try {
			while (rs.next()) {
				admin = new Administrateur(rs.getString("nom"), rs.getString("prenom"), rs.getString("email"),
						rs.getLong("telephone"), rs.getString("dateinscription"), rs.getString("MotDePasse"));
				Admins.add(admin);
			}

		} catch (SQLException s) {
			// TODO Auto-generated catch block
			s.printStackTrace();

		}
		Connection.disconnect();
		return Admins;
	}

	@Override
	public int mettreajour(int id, Administrateur admin) {
		// TODO Auto-generated method stub
		int nb = 0;
		Connection.connect();
		nb = Connection.miseajour("UPDATE administrateur set nom = '" + admin.getNom() + "', prenom = '"
				+ admin.getPrenom() + "',email = '" + admin.getEmail() + "',telephone = '" + admin.getTelephone()
				+ "',MotDePasse = '" + admin.getMotDePasse() + "' wHERE idAdmin = " + id);
		Connection.disconnect();
		return nb;

	}

	@Override
	public List<Projet> consulterMesProjets(int idAdmin) {
		// TODO Auto-generated method stub
		List<Projet> Projets = new ArrayList<Projet>();
		Projet pr = null;
		Connection.connect();
		ResultSet rs = Connection.select("select * from projet where idAdmin=" + idAdmin);
		try {
			while (rs.next()) {
				pr = new Projet(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBytes(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8));
				Projets.add(pr);
			}

		} catch (SQLException s) {
			// TODO Auto-generated catch block
			s.printStackTrace();

		}
		Connection.disconnect();
		return Projets;

	}

	@Override
	public int ajouterProjet(String titreProjet, String typeProjet, byte[] descriptionProjet,String filename, String etatProjet,
			String datelimite, int idCDP, int idAdmin) {
		// TODO Auto-generated method stub
		int nb = 0;
		java.sql.Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String  URL="jdbc:mysql://localhost:3306/mydb?useTimezone=true&serverTimezone=UTC";			
			conn=DriverManager.getConnection(URL, "root", "JosephELY200");

			PreparedStatement pstmt = conn.prepareStatement("insert into projet values(null,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, titreProjet);
			pstmt.setString(2, typeProjet);
			InputStream in = new ByteArrayInputStream(descriptionProjet);
			pstmt.setBinaryStream(3, in, descriptionProjet.length);
			pstmt.setString(4, etatProjet);
			pstmt.setString(5, datelimite);
			pstmt.setInt(6, idCDP);
			pstmt.setInt(7, idAdmin);
			pstmt.setString(8, filename);
			pstmt.executeUpdate();
			nb = 1;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return nb;
	}

	@Override
	public int ajouterProjet(Projet projet) {
		// TODO Auto-generated method stub
		int nb;
		Connection.connect();
		nb = Connection.miseajour("insert into projet values(null,'" + projet.getTitreProjet() + "','"
				+ projet.getTypeProjet() + "','" + projet.getDescriptionProjet() + "','" + projet.getEtatProjet()
				+ "','" + projet.getDatelimite() + "'" + projet.getIdCDP() + "," + projet.getIdAdmin() + ")");
		Connection.disconnect();
		return nb;

	}

	@Override
	/*public int modifierProjet(Projet projet) {
		int nb = 0;
		java.sql.Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String URL = "jdbc:mysql://localhost:3306/mydb?useTimezone=true&serverTimezone=UTC";
			conn = DriverManager.getConnection(URL, "root", "JosephELY200");

			PreparedStatement pstmt = conn.prepareStatement("UPDATE projet set titreProjet = ?, typeProjet = ?,descriptionProjet =?,etatProjet =?,datelimite=?,idCDP =?,filename=? where idprojet= ?");
			pstmt.setString(1, projet.getTitreProjet());
			pstmt.setString(2, projet.getTypeProjet());
			InputStream in = new ByteArrayInputStream(projet.getDescriptionProjet());
			pstmt.setBinaryStream(3, in, projet.getDescriptionProjet().length);
			pstmt.setString(4, projet.getEtatProjet());
			pstmt.setString(5, projet.getDatelimite());
			pstmt.setInt(6, projet.getIdCDP());
			pstmt.setString(7, projet.getFilename());
			pstmt.setInt(8, projet.getIdProjet());
			pstmt.executeUpdate();
			nb = 1;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return nb;
	}
	*/
	public int modifierProjet( Projet projet) {
		int nb = 0;
		java.sql.Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String URL="jdbc:mysql://localhost:3306/mydb?useTimezone=true&serverTimezone=UTC";			
			conn = DriverManager.getConnection(URL, "root", "JosephELY200");

			PreparedStatement pstmt = conn.prepareStatement("UPDATE projet set titreProjet = ?, typeProjet = ?,descriptionProjet =?,etatProjet =?,datelimite=?,idCDP =?,filename=? where idprojet= ?");
			pstmt.setString(1, projet.getTitreProjet());
			pstmt.setString(2, projet.getTypeProjet());
			InputStream in = new ByteArrayInputStream(projet.getDescriptionProjet());
			pstmt.setBinaryStream(3, in, projet.getDescriptionProjet().length);
			pstmt.setString(4, projet.getEtatProjet());
			pstmt.setString(5, projet.getDatelimite());
			pstmt.setInt(6, projet.getIdCDP());
			pstmt.setString(7, projet.getFilename());
			pstmt.setInt(8, projet.getIdProjet());
			pstmt.executeUpdate();
			nb = 1;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return nb;
	}
	

	@Override
	public Projet consulterProjet(int idAdmin) {
		// TODO Auto-generated method stub
		Projet projet = null;
		Connection.connect();
		ResultSet rs = Connection.select("select * from projet where idAdmin=" + idAdmin);
		try {
			if (rs.next())
				projet = new Projet(rs.getString(2), rs.getString(3), rs.getBytes(4), rs.getString(5), rs.getString(6),
						rs.getInt(7), rs.getInt(8));

		} catch (SQLException s) {
			// TODO Auto-generated catch block
			s.printStackTrace();
		}
		Connection.disconnect();
		return projet;
	}

	@Override
	public int supprimerProjet(int id) {
		// TODO Auto-generated method stub
		int nb = 0;
		Connection.connect();
		nb = Connection.miseajour("delete from projet where idProjet=" + id);
		Connection.disconnect();
		return nb;
	}

	@Override
	public Administrateur seconnecter(String gmail, String password) {
		Connection.connect();
		Administrateur admin = null;
		ResultSet rs = Connection
				.select("select * from administrateur where email='" + gmail + "' and motdepasse='" + password + "'");
		try {
			if (rs.next())
				admin = new Administrateur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getLong(5), rs.getString(6), rs.getString(7));
		} catch (SQLException s) {
			// TODO Auto-generated catch block
			s.printStackTrace();
		}
		Connection.disconnect();
		return admin;

	}

	@Override
	public ChefDeProjet findchef(int id) {
		ChefDeProjet chef = null;
		Connection.connect();
		ResultSet rs = Connection.select("select * from ChefDeProjet where idCDP =" + id);
		try {
			if (rs.next())
				chef = new ChefDeProjet(id, rs.getString(2), rs.getString(3), rs.getString(4), rs.getLong(5),
						rs.getString(6), rs.getString(7), rs.getInt(8));
		} catch (SQLException s) {
			// TODO Auto-generated catch block
			s.printStackTrace();
		}
		Connection.disconnect();
		return chef;
	}

	public Projet findprojet(int id) {
		Projet projet = null;
		Connection.connect();
		ResultSet rs = Connection.select("select * from projet where idprojet =" + id);
		try {
			if (rs.next())
				projet = new Projet(id,rs.getString(2), rs.getString(3), rs.getBytes(4), rs.getString(5), rs.getString(6),
						rs.getInt(7), rs.getInt(8),rs.getString(9));
		} catch (SQLException s) {
			// TODO Auto-generated catch block
			s.printStackTrace();
		}
		Connection.disconnect();
		return projet;
	}
	
	@Override
	public List<ChefDeProjet> consulterCDPsDansProjet(int id) {

		List<ChefDeProjet> Chefs = new ArrayList<ChefDeProjet>();
		ChefDeProjet c = null;
		Connection.connect();
		ResultSet rs = Connection.select("select * from chefdeprojet where idAdmin="+id+" and idcdp not in (select DISTINCT idcdp from projet)");
		try {
			while (rs.next()) {
				c = new ChefDeProjet(rs.getInt("idCDP"), rs.getString("Nom"), rs.getString("Prenom"),
						rs.getString("email"), rs.getLong("telephone"), rs.getString("dateinscription"),
						rs.getString("motdepasse"), rs.getInt("idAdmin"));
				Chefs.add(c);
			}

		} catch (SQLException s) {
			// TODO Auto-generated catch block
			s.printStackTrace();
		}
		return Chefs;
	}

	
	
	
	@Override
	public List<Document> consulterdocs(int idprojet) {
		List<Document> mesdocs = new ArrayList<Document>();
		Document c = null;
		Connection.connect();
		ResultSet rs = Connection.select("select * from document where idprojet="+idprojet);
		try {
			while(rs.next()) {
				c = new Document(rs.getInt("iddoc"), rs.getString("descriptiondoc"), rs.getBytes("document"), rs.getString("FILENAME"), rs.getInt("idprojet"));
				mesdocs.add(c);
			}
		} catch (SQLException s) {
			// TODO Auto-generated catch block
			s.printStackTrace();
		}
		Connection.disconnect();
		return mesdocs;
	}

	@Override
	public List<Planning> consulterplanning(int idprojet) {
		List<Planning> pl = new ArrayList<Planning>();
		Planning p = null;
		Connection.connect();
		ResultSet rs = Connection.select("select * from planning where idprojet="+idprojet);
		try {
			while(rs.next()) {
				p = new Planning(rs.getInt("idtache"), rs.getString("tache"),rs.getString("datedebut"),rs.getString("datefin"), rs.getInt("idprojet"));
				pl.add(p);
			}
		} catch (SQLException s) {
			// TODO Auto-generated catch block
			s.printStackTrace();
		}
		Connection.disconnect();
		return pl;
	}
    
	public Integer getNombreChefProjet(int id) {
		int nbChef = 0;
		Connection.connect();
		ResultSet rs = Connection.select("select count(*) as nbChef from chefdeprojet where idadmin=" + id);
		try {
			if (rs.next()) {
				nbChef = rs.getInt(1);
			}
		} catch (SQLException s) {
			// TODO Auto-generated catch block
			s.printStackTrace();
		}
		Connection.disconnect();
		return nbChef;
	}
	
	public Integer getNombreProjet(int id) {
		int nbProjet = 0;
		Connection.connect();
		ResultSet rs = Connection.select("select count(*) as nbProjet from projet where idadmin=" + id);
		try {
			if (rs.next()) {
				nbProjet = rs.getInt(1);
			}
		} catch (SQLException s) {
			// TODO Auto-generated catch block
			s.printStackTrace();
		}
		Connection.disconnect();
		return nbProjet;
	}
	
	public Integer getNombreDocument(int id) {
		int nbDocument = 0;
		Connection.connect();
		ResultSet rs = Connection.select("select count(doc.iddoc) as nbDocument from document doc, projet p where doc.idprojet = p.idprojet and p.idadmin="+id);
		try {
			if (rs.next()) {
				nbDocument = rs.getInt(1);
			}
		} catch (SQLException s) {
			// TODO Auto-generated catch block
			s.printStackTrace();
		}
		Connection.disconnect();
		return nbDocument;
	}
	
	public Integer getNombreEtatdebut(int id) {
		int nbDebut = 0;
		Connection.connect();
		ResultSet rs = Connection.select("select count(*)  as nbDebut from projet where etatprojet='Au Début' and idadmin="+id);
		try {
			if (rs.next()) {
				nbDebut = rs.getInt(1);
			}
		} catch (SQLException s) {
			// TODO Auto-generated catch block
			s.printStackTrace();
		}
		Connection.disconnect();
		return nbDebut;
	}
	
	@Override
	public Integer getNombreEtatencours(int id) {
		int nbCours = 0;
		Connection.connect();
		ResultSet rs = Connection.select("select count(*)  as nbCours from projet where etatprojet='En Cours' and idadmin="+id);
		try {
			if (rs.next()) {
				nbCours = rs.getInt(1);
			}
		} catch (SQLException s) {
			// TODO Auto-generated catch block
			s.printStackTrace();
		}
		Connection.disconnect();
		return nbCours;
	}
	
	@Override
	public Integer getNombreEtatenpause(int id) {
		int nbPause = 0;
		Connection.connect();
		ResultSet rs = Connection.select("select count(*)  as nbPause from projet where etatprojet='En pause' and idadmin="+id);
		try {
			if (rs.next()) {
				nbPause = rs.getInt(1);
			}
		} catch (SQLException s) {
			// TODO Auto-generated catch block
			s.printStackTrace();
		}
		Connection.disconnect();
		return nbPause;
	}
	
	@Override
	public Integer getNombreEtattermine(int id) {
		int nbTermine = 0;
		Connection.connect();
		ResultSet rs = Connection.select("select count(*)  as nbTermine from projet where etatprojet='Terminé' and idadmin="+id);
		try {
			if (rs.next()) {
				nbTermine = rs.getInt(1);
			}
		} catch (SQLException s) {
			// TODO Auto-generated catch block
			s.printStackTrace();
		}
		Connection.disconnect();
		return nbTermine;
	}

	
}
