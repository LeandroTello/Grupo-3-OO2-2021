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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.TPOO2.entities.UsuarioEntity;
import com.TPOO2.helpers.ViewRouteHelper;
import com.TPOO2.models.PerfilModel;
import com.TPOO2.models.UsuarioModel;
import com.TPOO2.pdf.UsuariosPDF;
import com.TPOO2.services.IPerfilService;
import com.TPOO2.services.IUsuarioService;
import com.lowagie.text.DocumentException;

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
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_AUDIT')")
	@GetMapping("mostrarUsuarios")
	 public ModelAndView mostrarUsuarios(Model model) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.USUARIO_LIST);
		mAV.addObject("usuarios", usuarioService.traerUsuarios());
		return mAV;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("modificarUsuario/{idUsuario}")
    public String editar(@PathVariable int idUsuario,Model model) {
        UsuarioModel usuario = usuarioService.traerPorId(idUsuario);
        model.addAttribute("usuario", usuario);
        model.addAttribute("perfiles", perfilService.traerPerfiles());
        return ViewRouteHelper.USUARIO_MODIF;
    }
	@GetMapping("eliminarUsuario/{idUsuario}")
    public RedirectView eliminar(@PathVariable int idUsuario,Model model) {
		UsuarioModel usuario = usuarioService.traerPorId(idUsuario);
		usuario.setIdPerfil(usuario.getPerfil().getIdPerfil());
		usuario.setActivo(false);
        usuarioService.insertOrUpdate(usuario);
        return new RedirectView(ViewRouteHelper.USUARIO_MOST);
    }
	@GetMapping("pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        List<UsuarioEntity> usuarios = usuarioService.getAll();

        UsuariosPDF exporter = new UsuariosPDF(usuarios);
        exporter.export(response);
    }
}

