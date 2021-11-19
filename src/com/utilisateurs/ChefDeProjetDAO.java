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

public class ChefDeProjetDAO implements iChefDeProjet {

	@Override
	public ChefDeProjet seconnecter(String gmail, String password) {
		Connection.connect();
		ChefDeProjet cdp = null; 
		ResultSet rs=Connection.select("select * from ChefDeProjet where email='"+gmail+"' and motdepasse='"+password+"'");
		try {
			if(rs.next())
				cdp=new ChefDeProjet(rs.getInt("idCDP"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getLong("telephone"),rs.getString("dateinscription"),rs.getString("MotDePasse"),rs.getInt("IdAdmin"));
			
		} catch (SQLException s) {
			// TODO Auto-generated catch block
			s.printStackTrace();
		}
		Connection.disconnect();
		return cdp;
	}

	@Override
	public int modifierchef(int id, String mdp) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection.connect();
		i =Connection.miseajour("update chefdeprojet set MotdePasse='"+mdp+"' where idCDP="+id);
		Connection.disconnect();
		return i;
	}

	public Projet monprojet(int id) {
		// TODO Auto-generated method stub
		Projet p = null;
		Connection.connect();
		ResultSet rs = Connection.select("select * from projet where idCDP=" + id);
		try {
			if (rs.next())
				p = new Projet(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getBytes(4), rs.getString(5), rs.getString(6));

		} catch (SQLException s) {
			// TODO Auto-generated catch block
			s.printStackTrace();
		}
		Connection.disconnect();
		return p;
	}

	@Override
	public int ajouterdoc(String Descriptiondoc, byte[]Document, String Filename, int IdProjet) {
		int nb = 0;
		java.sql.Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String URL="jdbc:mysql://localhost:3306/mydb?useTimezone=true&serverTimezone=UTC";		
			conn=DriverManager.getConnection(URL, "root", "JosephELY200");

			PreparedStatement pstmt = conn.prepareStatement("insert into document values(null,?,?,?,?)");
			pstmt.setString(1, Descriptiondoc);
			InputStream in = new ByteArrayInputStream(Document);
			pstmt.setBinaryStream(2, in, Document.length);
			pstmt.setString(3, Filename);
            pstmt.setInt(4, IdProjet);
			
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
	
	
	
	public Document finddocument(int id) {
		Document document = null;
		Connection.connect();
		ResultSet rs = Connection.select("select * from document where iddoc =" + id);
		try {
			if (rs.next())
				document = new Document(id,rs.getString(2), rs.getBytes(3), rs.getString(4), rs.getInt(5));
		} catch (SQLException s) {
			// TODO Auto-generated catch block
			s.printStackTrace();
		}
		Connection.disconnect();
		return document;
	}

	@Override
	public int supprimerdoc(int id) {
		// TODO Auto-generated method stub
		int i = 0 ;
		Connection.connect();
		i = Connection.miseajour("delete from document where iddoc="+id);
		Connection.disconnect();
		return i;
	}

	@Override
	public int ajoutertache(String tache,String datedebut, String datefin, int idprojet) {
		int i=0;
		Connection.connect();
		i=Connection.miseajour("insert into planning values(null,'"+tache+"','"+datedebut+"','"+datefin+"',"+idprojet+")");
		Connection.disconnect();
		return i;
	}

	@Override
	public int modifiertache(int id, String nvtache,String nvdatedebut,String nvdatefin) {
		int i=0;
		Connection.connect();
		i=Connection.miseajour("update planning set tache='"+nvtache+"',datedebut='"+nvdatedebut+"',datefin='"+nvdatefin+"'where idtache="+id);
		Connection.disconnect();
		return i;
	}

	@Override
	public int supprimertache(int idtache) {
		int i=0;
		Connection.connect();
		i=Connection.miseajour("delete from planning where idtache="+idtache);
		Connection.disconnect();
		return i;
	}

	@Override
	public List<Planning> consultermonplanning(int idprojet) {
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

	@Override
	public Planning findtache(int idtache) {
		Planning planning = null;
		Connection.connect();
		ResultSet rs = Connection.select("select * from planning where idtache =" + idtache);
		try {
			if (rs.next())
				planning = new Planning(idtache,rs.getString("tache"),rs.getString("datedebut"),rs.getString("datefin"), rs.getInt("idprojet"));
		} catch (SQLException s) {
			// TODO Auto-generated catch block
			s.printStackTrace();
		}
		Connection.disconnect();
		return planning;
	}
}
