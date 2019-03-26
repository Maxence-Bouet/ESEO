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
	
	@RequestMapping(value="/allVille", method=RequestMethod.GET)
	@ResponseBody
	public List<Ville> get() {
		List<Ville> villes = new ArrayList<Ville>();
		try {
			Connection connect = Config.Connexion("maven", "Admin", "network");
			Statement stm = connect.createStatement();
			ResultSet rset = stm.executeQuery("SELECT * FROM ville_france");
			while (rset.next()) {
				Ville ville = new Ville();
				ville.fill(rset);
				villes.add(ville);
				System.out.println(ville.getNom_commune());
			}
			return villes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
