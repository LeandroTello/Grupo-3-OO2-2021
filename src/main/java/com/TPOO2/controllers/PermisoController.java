package com.TPOO2.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.TPOO2.helpers.ViewRouteHelper;
import com.TPOO2.models.PermisoDiarioModel;
import com.TPOO2.models.PermisoPeriodoModel;
import com.TPOO2.models.RodadoModel;
import com.TPOO2.repositories.IPermisoRepository;
import com.TPOO2.repositories.IPersonaRepository;
import com.TPOO2.repositories.IRodadoRepository;
import com.TPOO2.services.ILugarService;
import com.TPOO2.services.IPermisoService;
import com.TPOO2.services.IPersonaService;
import com.TPOO2.services.IRodadoService;

@Controller
@RequestMapping("/permiso")
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
	@Autowired
	@Qualifier("lugarService")
	private ILugarService lugarService;
	@Autowired
	@Qualifier("personaRepository")
	private IPersonaRepository personaRepository;
	@Autowired
	@Qualifier("rodadoRepository")
	private IRodadoRepository rodadoRepository;

	@PreAuthorize("hasRole('ROLE_GUEST')")
	@GetMapping("agregarPermisoPeriodo")
	public ModelAndView agregarPermisoPeriodo(Model model) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERMISO_PERIODO);
		mAV.addObject("lugares", lugarService.traerLugares());
		mAV.addObject("periodo", new PermisoPeriodoModel());
		return mAV;
	}

	@PreAuthorize("hasRole('ROLE_GUEST')")
	@GetMapping("agregarPermisoDiario")
	public ModelAndView agregarPermisoDiario(Model model) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERMISO_DIA);
		mAV.addObject("diario", new PermisoDiarioModel());
		return mAV;
	}

	@PostMapping("insertarPermisoPeriodo")
	public ModelAndView agregarPermisoDiario(@Valid @ModelAttribute("periodo")PermisoPeriodoModel permisoPeriodoModel, Model model, BindingResult bindingResult) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERMISO_PERIODO);
		if(personaRepository.traerPersonaEntityPorDni(permisoPeriodoModel.getDni())==null) {
			FieldError error = new FieldError("periodo","dni","");
			bindingResult.addError(error);
		}
		if(rodadoRepository.traerRodadoEntityPorDominio(permisoPeriodoModel.getDominio())==null) {
			FieldError error = new FieldError("periodo","dominio","");
			bindingResult.addError(error);
		}
		if(bindingResult.hasErrors()) {
			mAV.addObject("lugares", lugarService.traerLugares());
			mAV.addObject("periodo", permisoPeriodoModel);
		}
		else {
			permisoService.insertOrUpdate(permisoPeriodoModel);
			mAV.setViewName(ViewRouteHelper.USER_ROOT);
		}
		return mAV;
	}
}
