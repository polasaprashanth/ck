package com.example.Audit_manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Audit_manager.model.Modules;
import com.example.Audit_manager.repository.ModuleRepository;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/Module")
public class ModuleController {
	@Autowired
	private ModuleRepository module_Repository;
	
	@GetMapping("/getModuleDetails")
	public List<Modules> getModuleDetails() {
		return  module_Repository.findAll();
	}
	
	//posting module details to table
	
	@PostMapping("/createModule")
	public Modules createModule(@Valid @RequestBody Modules modules) {
		
		return module_Repository.save(modules);
		
	}
	
	

}
