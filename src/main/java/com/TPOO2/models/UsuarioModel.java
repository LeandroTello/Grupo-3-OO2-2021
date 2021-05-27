package com.TPOO2.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.TPOO2.enums.Tipo;

public class UsuarioModel {

	private int idUsuario;
	
	private String nombre;
	
	private String apellido;
	
	private Tipo tipo;
	
	@Min(value=40000)
	@Max(value=100000000)
	private long dni;
	
	private String email;
	
	@Size(min=5,max=20)
	private String nombreUsuario;
	
	@Size(min=3,max=20)
	private String pass;
	
	private boolean activo;
	private int idPerfil;
	private PerfilModel perfil;

	public UsuarioModel() {
	}

	public UsuarioModel(String nombre, String apellido, Tipo tipo, long dni, String email, String nombreUsuario,
			String pass,boolean activo,int idPerfil) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipo = tipo;
		this.dni = dni;
		this.email = email;
		this.nombreUsuario = nombreUsuario;
		this.pass = pass;
		this.activo = activo;
		this.idPerfil = idPerfil;
	}
	
	public UsuarioModel(String nombre, String apellido, Tipo tipo, long dni, String email, String nombreUsuario,
			String pass) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipo = tipo;
		this.dni = dni;
		this.email = email;
		this.nombreUsuario = nombreUsuario;
		this.pass = pass;
	}
	
	public UsuarioModel(int idUsuario,String nombre, String apellido, Tipo tipo, long dni, String email, String nombreUsuario,
			String pass,PerfilModel perfil) {
		super();
		this.setIdUsuario(idUsuario);
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipo = tipo;
		this.dni = dni;
		this.email = email;
		this.nombreUsuario = nombreUsuario;
		this.pass = pass;
		this.perfil = perfil;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public int getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public PerfilModel getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilModel perfil) {
		this.perfil = perfil;
	}
	


}
