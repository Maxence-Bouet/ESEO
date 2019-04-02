package com.controller;

import java.sql.Connection;
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
	
}
