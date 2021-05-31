package com.TPOO2.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.TPOO2.helpers.ViewRouteHelper;
import com.TPOO2.models.PersonaModel;
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
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERSONA_AGREGAR);
		mAV.addObject("persona", new PersonaModel());
		return mAV;
	}
	
	@PostMapping("insertarPersona")
	public ModelAndView insertarPersona(@Valid @ModelAttribute("persona") PersonaModel personaModel,BindingResult bindingResult) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERSONA_AGREGAR);
		if(bindingResult.hasErrors()) {
			mAV.addObject("usuario",personaModel);
		}
		else {
		personaService.insertOrUpdate(personaModel);
		mAV.setViewName(ViewRouteHelper.USER_ROOT);
		}
		return mAV;
	}
}