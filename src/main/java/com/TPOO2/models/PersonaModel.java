package com.TPOO2.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class PersonaModel {

	private int idPersona;
	
	@Size(min=5,max=20)
	private String nombre;
	
	@Size(min=5,max=20)
	private String apellido;
	
	@Min(value=1000000)
	private long dni;
	
	public PersonaModel () {}

	public PersonaModel(int idPersona, String nombre, String apellido, long dni) {
		super();
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
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

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "PersonaModel [idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ "]";
	}
	
	
}
