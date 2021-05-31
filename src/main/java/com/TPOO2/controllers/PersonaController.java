package com.TPOO2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.TPOO2.services.IPersonaService;

@Controller
@RequestMapping("/home")
public class PersonaController {

	@Autowired
	@Qualifier("personaService")
	private IPersonaService personaService;
	
	
}
