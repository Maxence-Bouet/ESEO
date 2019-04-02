package com.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.config.Config;
import com.dao.Ville;

@RestController
public class TestController {
	@RequestMapping(value="/test", method=RequestMethod.GET)
	@ResponseBody
	public String get(@RequestParam(required = false, value="value") String value) {
		System.out.println("Appel GET");
		System.out.println("value : " + value);
		
		return value;
	}
	
	@RequestMapping(value="/Ville", method=RequestMethod.GET)
	@ResponseBody
	public List<Ville> get1(@RequestParam(required = false, value="name") String value) {
		List<Ville> villes = new ArrayList<Ville>();
		try {
			Connection connect = Config.Connexion("maven", "Admin", "network");
			Statement stm = connect.createStatement();
			ResultSet rset;
			if (value != null)
				rset = stm.executeQuery("SELECT * FROM ville_france WHERE Nom_commune LIKE '%" + value.toUpperCase() + "%'");
			else 
				rset = stm.executeQuery("SELECT * FROM ville_france");
				
			while (rset.next()) {
				Ville ville = new Ville();
				ville.fill(rset);
				villes.add(ville);
			}
			return villes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value="/CreateVille", method=RequestMethod.GET)
	@ResponseBody
	public int put(@RequestParam(required = true, value="id") String id, @RequestParam(required = true, value="name") String name, @RequestParam(required = true, value="code") String code, @RequestParam(required = true, value="libelle") String libelle, @RequestParam(required = true, value="ligne") String ligne, @RequestParam(required = true, value="latitude") String latitude, @RequestParam(required = true, value="longitude") String longitude) {	
		int test = -1;
		try {
			Connection connect = Config.Connexion("maven", "Admin", "network");
			Statement stm = connect.createStatement();
			test = stm.executeUpdate("INSERT INTO `ville_france`(`Code_commune_INSEE`, `Nom_commune`, `Code_postal`, `Libelle_acheminement`, `Ligne_5`, `Latitude`, `Longitude`) VALUES ('" + id + "', '" + name + "', '" + code + "', '" + libelle + "', '" + ligne + "', '" + latitude + "', '" + longitude + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return test;
	}
	
	@RequestMapping(value="/ChangeVille", method=RequestMethod.GET)
	@ResponseBody
	public int post(@RequestParam(required = true, value="id") String id, @RequestParam(required = false, value="name") String name, @RequestParam(required = false, value="code") String code, @RequestParam(required = false, value="libelle") String libelle, @RequestParam(required = false, value="ligne") String ligne, @RequestParam(required = false, value="latitude") String latitude, @RequestParam(required = false, value="longitude") String longitude) {
		int test = -1;
		try {
			Connection connect = Config.Connexion("maven", "Admin", "network");
			Statement stm = connect.createStatement();
			String sql = "";
			if (name != null)
				sql += "Nom_commune='" + name + "' AND ";
			if (code != null)
				sql += "Code_postal='" + code + "' AND ";
			if (libelle != null)
				sql += "Libelle_acheminement='" + libelle + "' AND ";
			if (ligne != null)
				sql += "Ligne_5='" + ligne + "' AND ";
			if (latitude != null)
				sql += "Latitude='" + latitude + "' AND ";
			if (longitude != null)
				sql += "Longitute='" + longitude + "' AND ";
			sql = sql.substring(0, sql.length() - 4);
			test = stm.executeUpdate("UPDATE ville_france SET " + sql + "WHERE Code_commune_INSEE='" + id + "'");
		} catch (SQLException e ) {
			e.printStackTrace();
		}
		return test;
	}
	
}
