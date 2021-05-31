package com.TPOO2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.TPOO2.helpers.ViewRouteHelper;
import com.TPOO2.models.PerfilModel;
import com.TPOO2.services.IPersonaService;

@Controller
@RequestMapping("/home")
public class PersonaController {

	@Autowired
	@Qualifier("personaService")
	private IPersonaService personaService;
	
	@PreAuthorize("hasRole('ROLE_GUEST')")
	@GetMapping("agregarPersona")
	 public ModelAndView agregarPersona(Model model) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERFIL_AGREGAR);
		mAV.addObject("personas", personaService.traerPersonas());
		mAV.addObject("persona", new PerfilModel());
		return mAV;
	}
}
