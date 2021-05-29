package com.TPOO2.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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

import com.TPOO2.entities.PerfilEntity;
import com.TPOO2.helpers.ViewRouteHelper;
import com.TPOO2.models.PerfilModel;
import com.TPOO2.pdf.PerfilesPDF;
import com.TPOO2.services.IPerfilService;
import com.lowagie.text.DocumentException;


@Controller
@RequestMapping("/home")
public class PerfilController {
	
	@Autowired
	@Qualifier("perfilService")
	private IPerfilService perfilService;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("agregarPerfil")
	 public ModelAndView agregarPerfil(Model model) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERFIL_AGREGAR);
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
        PerfilModel perfil = perfilService.traerPerfilModelPorId(idPerfil);
        model.addAttribute("perfil", perfil);
        return ViewRouteHelper.PERFIL_MODIFICAR;
    }

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("eliminarPerfil/{idPerfil}")
    public RedirectView eliminar(@PathVariable int idPerfil,Model model) {
        PerfilModel perfil = perfilService.traerPerfilModelPorId(idPerfil);
        perfil.setActivo(false);
        perfilService.insertOrUpdate(perfil);
        return new RedirectView(ViewRouteHelper.PERFIL_MOSTRAR);
    }
	
	@GetMapping("pdfPerfil")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        List<PerfilEntity> perfiles = perfilService.traerPerfilesParaPDF();

        PerfilesPDF exporter = new PerfilesPDF(perfiles);
        exporter.export(response);
    }
	
}