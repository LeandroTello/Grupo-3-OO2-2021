package com.TPOO2.helpers;

public class ViewRouteHelper {
	// USER
	public final static String USER_LOGIN = "user/login";
	public final static String USER_LOGOUT = "user/logout";
	public final static String USER_ROOT = "redirect:/";
	
	// USUARIO
	public final static String USUARIO_AGREGAR = "usuario/cargarUsuario";
	public final static String USUARIO_CARGAR ="/home/agregarUsuario";
	public final static String USUARIO_LIST = "usuario/listadoUsuario";
	public final static String USUARIO_MODIF = "usuario/modificar";
	public final static String USUARIO_MOSTRAR = "/home/mostrarUsuarios";
	
	
	// PERFIL
	
	public final static String PERFIL_AGREGAR = "perfil/insert";
	public final static String PERFIL_CARGAR = "agregarPerfil";
	public final static String PERFIL_LIST = "perfil/listadoPerfil";
	public final static String PERFIL_MODIFICAR = "perfil/modificar";
	public final static String PERFIL_MOSTRAR = "/home/mostrarPerfiles";
	
	// PERSONA
	
	public final static String PERSONA_AGREGAR = "persona/cargarPersona";
	
	// HOME
	
	public final static String HOME_INDEX = "home/index";
	

	// REDIRECT
	
	public final static String INICIO = "/";
	
	// PERMISO
	
	public final static String PERMISO_PERIODO = "permisos/agregarPermisoPeriodo";
	public final static String PERMISO_DIA = "permisos/agregarPermisoDiario";
	public final static String PERMISO_RODADO ="permisos/permisoPorRodado";
	public final static String PERMISO_RODADO_LISTA ="permisos/listaPermisosPorRodado";
	public final static String PERMISO_PERSONA ="permisos/permisoPorDNI";
	public final static String PERMISO_PERSONA_LISTA ="permisos/listaPermisosPorPersona";
	public final static String PERMISO_FECHA ="permisos/permisoPorFecha";
	public final static String PERMISO_FECHA_LISTA ="permisos/listaPermisosPorFecha";
	public final static String PERMISO_FECHA_LUGAR ="permisos/permisoPorFechaYLugar";

	//RODADO
	public final static String RODADO_AGREGAR = "rodado/IngresarRodado";


}
