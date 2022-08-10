package com.myapp.thymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myapp.thymeleaf.model.Employe;

@Controller
@RequestMapping("/employes")
public class EmployeController {
	
	// Rajouter Liste
	
	private List<Employe> lesEmployes;
	
	// créer les employés
	
	@PostConstruct
	private void empData() {
		
		Employe emp1 = new Employe(1, "Billy", "Jean", "billy@mail.com");
		Employe emp2 = new Employe(2, "Max", "Maxance", "max@mail.com");
		Employe emp3 = new Employe(3, "Thierry", "Golo", "thierry@mail.com");
		
	// créer la liste
		
	lesEmployes = new ArrayList<>();
		
	// ajout des employés à la liste
	
	lesEmployes.add(emp1);	
	lesEmployes.add(emp2);	
	lesEmployes.add(emp3);	
	
	}
	
	// mapper "/liste"
	
	@GetMapping("/liste")
	public String listeEmployes(Model mod) {
		mod.addAttribute("employes", lesEmployes);
		
		//nom de notre fichier html
		return "liste-employes";
	}

}
