package com.TPOO2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
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
	
	@GetMapping("mostrarPerfiles")
	 public ModelAndView mostrarPerfiles(Model model) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERFIL_LIST);
		mAV.addObject("perfiles", perfilService.traerPerfiles());
		return mAV;
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("modificarPerfil/{idPerfil}")
    public String editar(@PathVariable int idPerfil,Model model) {
        PerfilModel perfil = perfilService.traerPorId(idPerfil);
        model.addAttribute("perfil", perfil);
        return ViewRouteHelper.PERFIL_MODIF;
    }

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("eliminarPerfil/{idPerfil}")
    public RedirectView eliminar(@PathVariable int idPerfil,Model model) {
        PerfilModel perfil = perfilService.traerPorId(idPerfil);
        perfil.setActivo(false);
        perfilService.insertOrUpdate(perfil);
        return new RedirectView(ViewRouteHelper.PERFIL_MOST);
    }
	
}