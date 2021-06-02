package com.TPOO2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.TPOO2.services.IPermisoService;
import com.TPOO2.services.IPersonaService;
import com.TPOO2.services.IRodadoService;

@Controller
@RequestMapping("/home")
public class PermisoController {

	@Autowired
	@Qualifier("personaService")
	private IPersonaService personaService;
	
	@Autowired
	@Qualifier("rodadoService")
	private IRodadoService rodadoService;
	
	@Autowired
	@Qualifier("permisoService")
	private IPermisoService permisoService;

	
}
