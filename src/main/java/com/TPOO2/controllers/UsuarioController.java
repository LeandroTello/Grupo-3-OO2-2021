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
import com.TPOO2.models.UsuarioModel;
import com.TPOO2.services.IPerfilService;
import com.TPOO2.services.IUsuarioService;

@Controller
@RequestMapping("/home")
public class UsuarioController {
	
	@Autowired
	@Qualifier("usuarioService")
	private IUsuarioService usuarioService;
	
	@Autowired
	@Qualifier("perfilService")
	private IPerfilService perfilService;
	
	@GetMapping("agregarUsuario")
	public ModelAndView agregarUsuario() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERFIL_USER);
		mAV.addObject("perfiles", perfilService.traerPerfiles());
		mAV.addObject("usuario",new UsuarioModel());
		return mAV;
	}
	
	@PostMapping("insertUsuario")
	public RedirectView insertarUsuario(@ModelAttribute("usuario") UsuarioModel usuarioModel) {
		usuarioModel.setActivo(true);
		usuarioService.insertOrUpdate(usuarioModel);
		return new RedirectView(ViewRouteHelper.USUARIO_CARGAR);
	}
}

