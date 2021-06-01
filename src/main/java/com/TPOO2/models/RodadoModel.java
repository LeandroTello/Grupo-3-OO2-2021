package com.TPOO2.models;

import javax.validation.constraints.Size;

public class RodadoModel {

	private int idRodado;
	
	@Size(min = 5, max = 9)	
	private String dominio;
	
	@Size(min = 3, max = 20)
	private String vehiculo;

	public RodadoModel(int idRodado, String dominio, String vehiculo) {
		super();
		this.idRodado = idRodado;
		this.dominio = dominio;
		this.vehiculo = vehiculo;
	}

	public RodadoModel() {
	}

	public int getIdRodado() {
		return idRodado;
	}

	public void setIdRodado(int idRodado) {
		this.idRodado = idRodado;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public String getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}

	@Override
	public String toString() {
		return "RodadoModel [idRodado=" + idRodado + ", dominio=" + dominio + ", vehiculo=" + vehiculo + "]";
	}

}
