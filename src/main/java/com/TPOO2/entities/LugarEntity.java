package com.TPOO2.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lugar")
public class LugarEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLugar;
	
	@Column(name = "lugar", nullable = false)
	private String lugar;
	
	@Column(name = "codigoPostal", nullable = false)
	private String codigoPostal;
	
	
	public LugarEntity(int idLugar, String lugar, String codigoPostal) {
		super();
		this.setIdLugar(idLugar);
		this.lugar = lugar;
		this.codigoPostal = codigoPostal;
	}
	public LugarEntity() {}

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
		return "LugarEntity [idLugar=" + idLugar + ", lugar=" + lugar + ", codigoPostal=" + codigoPostal + "]";
	}
	
	
}
