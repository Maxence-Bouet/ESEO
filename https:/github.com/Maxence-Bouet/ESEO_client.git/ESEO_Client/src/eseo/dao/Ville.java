package eseo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Ville {
	
	private String code_commune_INSEE;
	private String nom_commune;
	private String code_postal;
	private String libelle_acheminement;
	private String ligne_5;
	private String latitude;
	private String longitude;
	
	public String getCode_commune_INSEE() {
		return code_commune_INSEE;
	}
	public void setCode_commune_INSEE(String Code_commune_INSEE) {
		code_commune_INSEE = Code_commune_INSEE;
	}
	public String getNom_commune() {
		return nom_commune;
	}
	public void setNom_commune(String Nom_commune) {
		nom_commune = Nom_commune;
	}
	public String getCode_postal() {
		return code_postal;
	}
	public void setCode_postal(String Code_postal) {
		code_postal = Code_postal;
	}
	public String getLibelle_acheminement() {
		return libelle_acheminement;
	}
	public void setLibelle_acheminement(String Libelle_acheminement) {
		libelle_acheminement = Libelle_acheminement;
	}
	public String getLigne_5() {
		return ligne_5;
	}
	public void setLigne_5(String Ligne_5) {
		ligne_5 = Ligne_5;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String Latitude) {
		latitude = Latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String Longitude) {
		longitude = Longitude;
	}
	
	public void fill(ResultSet rset) throws SQLException {
		setCode_commune_INSEE(rset.getString("code_commune_INSEE"));
		setNom_commune(rset.getString("Nom_commune"));
		setCode_postal(rset.getString("Code_postal"));
		setLibelle_acheminement(rset.getString("Libelle_acheminement"));
		setLigne_5(rset.getString("Ligne_5"));
		setLatitude(rset.getString("Latitude"));
		setLongitude(rset.getString("Longitude"));
	}

}

