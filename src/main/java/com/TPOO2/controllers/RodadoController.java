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

import com.TPOO2.helpers.ViewRouteHelper;
import com.TPOO2.models.RodadoModel;
import com.TPOO2.repositories.IRodadoRepository;
import com.TPOO2.services.IRodadoService;

@Controller
@RequestMapping("rodado")
public class RodadoController {
	@Autowired
	@Qualifier("rodadoService")
	private IRodadoService rodadoService;
	
	@Autowired
	@Qualifier("rodadoRepository")
	private IRodadoRepository rodadoRepository;

	@PreAuthorize("hasRole('ROLE_GUEST')")
	@GetMapping("ingresarRodado")
	public ModelAndView ingresarRodado(Model model) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.RODADO_AGREGAR);
		mAV.addObject("rodado",new RodadoModel());
		return mAV;
	}
	
	@PostMapping("insertarRodado")
	public ModelAndView insertarRodado(@Valid @ModelAttribute("rodado") RodadoModel rodadoModel,BindingResult bindingResult) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.RODADO_AGREGAR);
		if(rodadoRepository.traerRodadoEntityPorDominio(rodadoModel.getDominio())!=null) {
			FieldError error = new FieldError("rodado", "dominio", "");
			bindingResult.addError(error);
		}
		if(bindingResult.hasErrors()) {
			mAV.addObject("rodado",rodadoModel);
		}
		else {
		rodadoService.insertOrUpdate(rodadoModel);
		mAV.setViewName(ViewRouteHelper.USER_ROOT);
		}
		return mAV;
	}
	
}
