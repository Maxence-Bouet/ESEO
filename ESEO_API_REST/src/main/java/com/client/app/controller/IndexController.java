package com.client.app.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
 
    @RequestMapping("/")
    public String home(Map<String, Object> model) {
    	//URL url = new URL("http://localhost:8181");
    	
    	
    	model.put("testing", "It's working");
    	
        model.put("message", "HowToDoInJava Reader !!");
        return "index";
    }
     
    @RequestMapping("/next")
    public String next(Map<String, Object> model) {
        model.put("message", "You are in new page !!");
        return "next";
    }
 
}