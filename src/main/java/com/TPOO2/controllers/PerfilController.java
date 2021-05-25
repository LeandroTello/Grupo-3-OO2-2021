package com.TPOO2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.TPOO2.helpers.ViewRouteHelper;
import com.TPOO2.models.PerfilModel;
import com.TPOO2.services.IPerfilService;


@Controller
@RequestMapping("/home")
public class PerfilController {
	
	@Autowired
	@Qualifier("perfilService")
	private IPerfilService perfilService;
	
	
	@GetMapping("agregarPerfil")
	 public ModelAndView agregarPerfil(Model model) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERFIL_INSERT);
		mAV.addObject("perfiles", perfilService.traerPerfiles());
		mAV.addObject("perfil", new PerfilModel());
		return mAV;
	}

	
	@PostMapping("insertPerfil")
	public RedirectView insertarPerfil(@ModelAttribute("perfil") PerfilModel perfilModel) {
		perfilModel.setActivo(true);
		perfilService.insertOrUpdate(perfilModel);
		return new RedirectView(ViewRouteHelper.PERFIL_CARGAR);
	}
}