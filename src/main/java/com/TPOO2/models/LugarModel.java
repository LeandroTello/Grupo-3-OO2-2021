package com.TPOO2.models;

public class LugarModel {

	private int idLugar;
	private String lugar;
	private String codigoPostal;
	
	public LugarModel() {}
	
	public LugarModel(int idLugar, String lugar, String codigoPostal) {
		super();
		this.idLugar = idLugar;
		this.lugar = lugar;
		this.codigoPostal = codigoPostal;
	}

	public int getIdLugar() {
		return idLugar;
	}

	public void setIdLugar(int idLugar) {
		this.idLugar = idLugar;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	@Override
	public String toString() {
		return "LugarModel [idLugar=" + idLugar + ", lugar=" + lugar + ", codigoPostal=" + codigoPostal + "]";
	}
	
}
