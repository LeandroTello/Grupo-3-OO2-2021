package com.TPOO2.models;

import com.TPOO2.enums.Tipo;

public class UsuarioModel {

	private int idUsuario;
	private String nombre;
	private String apellido;
	private Tipo tipo;
	private long dni;
	private String email;
	private String nombreUsuario;
	private String pass;
	private boolean activo;
	private PerfilModel perfil;

	public UsuarioModel() {
	}

	public UsuarioModel(String nombre, String apellido, Tipo tipo, long dni, String email, String nombreUsuario,
			String pass, PerfilModel perfil) {
		super();
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

	protected void setIdUsuario(int idUsuario) {
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

	public PerfilModel getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilModel perfil) {
		this.perfil = perfil;
	}

}
