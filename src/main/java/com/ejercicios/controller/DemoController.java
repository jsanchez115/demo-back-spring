package com.ejercicios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ejercicios.repo.IPersonaRepo;

@Controller
public class DemoController {
	
	@Autowired
	private IPersonaRepo repo;
	
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="Covid-19 World") String name, Model model) {
		
		
		/*Persona p = new Persona();
		p.setIdPersona(2);
		p.setNombre("Has");		
		repo.save(p);*/
		
		model.addAttribute("name", name);
		
		return "greeting";
	}
	
	@GetMapping("/")
	public String listar(Model model) {	
	
		model.addAttribute("personas", repo.findAll());
		
		return "listarPersonas";
	}

}
