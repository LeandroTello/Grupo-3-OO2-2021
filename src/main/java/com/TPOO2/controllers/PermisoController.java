package com.TPOO2.controllers;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PostAuthorize;
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

import com.TPOO2.helpers.ViewRouteHelper;
import com.TPOO2.models.PermisoDiarioModel;
import com.TPOO2.models.PermisoModel;
import com.TPOO2.models.PermisoPeriodoModel;
import com.TPOO2.models.PersonaModel;
import com.TPOO2.models.RodadoModel;
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


	@PostMapping("insertarPermisoPeriodo")
	public ModelAndView insertarPermisoPeriodo(@Valid @ModelAttribute("periodo")PermisoPeriodoModel permisoPeriodoModel, Model model, BindingResult bindingResult) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERMISO_PERIODO);
		if(personaRepository.traerPersonaEntityPorDni(permisoPeriodoModel.getDni())==null) {
			FieldError error = new FieldError("periodo","dni","");
			bindingResult.addError(error);
		}
		if(rodadoRepository.traerRodadoEntityPorDominio(permisoPeriodoModel.getDominio())==null) {
			FieldError error = new FieldError("periodo","dominio","");
			bindingResult.addError(error);
		}
		if(LocalDate.parse(permisoPeriodoModel.getFechaInicial()).isBefore(LocalDate.now())) {
			FieldError error = new FieldError("periodo","fecha","");
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
	
	@PreAuthorize("hasRole('ROLE_GUEST')")
	@GetMapping("agregarPermisoDiario")
	public ModelAndView agregarPermisoDiario(Model model) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERMISO_DIA);
		mAV.addObject("lugares", lugarService.traerLugares());
		mAV.addObject("diario", new PermisoDiarioModel());
		return mAV;
	}
	
	@PostMapping("insertarPermisoDiario")
	public ModelAndView insertarPermisoDiario(@Valid @ModelAttribute("diario")PermisoDiarioModel permisoDiarioModel, BindingResult bindingResult) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERMISO_DIA);
		if(personaRepository.traerPersonaEntityPorDni(permisoDiarioModel.getDni())==null) {
			FieldError error = new FieldError("diario","dni","");
			bindingResult.addError(error);
		}
		if(LocalDate.parse(permisoDiarioModel.getFechaInicial()).isBefore(LocalDate.now())) {
			FieldError error = new FieldError("diario","fecha","");
			bindingResult.addError(error);
		}
		
		if(bindingResult.hasErrors()) {
			mAV.addObject("lugares", lugarService.traerLugares());
			mAV.addObject("periodo", permisoDiarioModel);
		}
		else {
			permisoService.insertOrUpdate(permisoDiarioModel);
			mAV.setViewName(ViewRouteHelper.USER_ROOT);
		}
		return mAV;
	}

	@PreAuthorize("hasRole('ROLE_AUDIT')")
	@GetMapping("permisoPorRodado")
	public ModelAndView permisoPorRodado(Model model) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERMISO_RODADO);
		mAV.addObject("rodado", new RodadoModel());
		return mAV;
	}
	@PreAuthorize("hasRole('ROLE_AUDIT')")
	@PostMapping("listaDeRodado")
	public ModelAndView traer(Model model,@Valid @ModelAttribute("rodado")RodadoModel rodadoModel) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERMISO_RODADO_LISTA);
		mAV.addObject("permisos", permisoService.traerPermisosPorDominio(rodadoModel.getDominio()));
		return mAV;
	}
	@PreAuthorize("hasAnyRole('ROLE_AUDIT','ROLE_GUEST')")
	@GetMapping("permisoPorDNI")
	public ModelAndView permisoPorDNI(Model model) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERMISO_PERSONA);
		mAV.addObject("persona", new PersonaModel());
		return mAV;
	}
	@PreAuthorize("hasAnyRole('ROLE_AUDIT','ROLE_GUEST')")
	@PostMapping("listaDePersona")
	public ModelAndView listaDePersona(Model model,@Valid @ModelAttribute("persona")PersonaModel personaModel) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERMISO_PERSONA_LISTA);
		mAV.addObject("diario", permisoService.traerPermisosDiarosPorDNI(personaModel.getDni()));
		mAV.addObject("periodo", permisoService.traerPermisosPeriodoPorDNI(personaModel.getDni()));
		return mAV;
	}
	@PreAuthorize("hasRole('ROLE_AUDIT')")
	@GetMapping("permisoPorFecha")
	public ModelAndView permisoPorFecha(Model model) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERMISO_FECHA);
		mAV.addObject("permiso", new PermisoDiarioModel());
		return mAV;
	}
	@PreAuthorize("hasRole('ROLE_AUDIT')")
	@PostMapping("listaDePermisosPorFecha")
	public ModelAndView listaDePermisosPorFecha(Model model,@Valid @ModelAttribute("permiso")PermisoDiarioModel permisoDiarioModel) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERMISO_FECHA_LISTA);
		mAV.addObject("diario", permisoService.traerPermisosDiarosPorFecha(LocalDate.parse(permisoDiarioModel.getFechaDesde()),LocalDate.parse(permisoDiarioModel.getFechaHasta())));
		mAV.addObject("periodo", permisoService.traerPermisosPeriodoPorFecha(LocalDate.parse(permisoDiarioModel.getFechaDesde()),LocalDate.parse(permisoDiarioModel.getFechaHasta())));
		return mAV;
	}
	
	@PreAuthorize("hasRole('ROLE_AUDIT')")
	@GetMapping("permisoPorLugar")
	public ModelAndView permisoPorLugar(Model model) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERMISO_LUGAR);
		mAV.addObject("permiso", new PermisoDiarioModel());
		return mAV;
	}
}
