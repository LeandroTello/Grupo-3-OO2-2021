package com.TPOO2.models;

import java.util.HashSet;
import java.util.Set;

import com.TPOO2.entities.UsuarioEntity;

public class PerfilModel {

	private int idPerfil;
	private String tipoPerfil;
	private boolean activo;
	private Set<UsuarioEntity> usuarios = new HashSet<UsuarioEntity>();

	public PerfilModel() {
	}

	public PerfilModel(String tipoPerfil, Set<UsuarioEntity> usuarios) {
		super();
		this.tipoPerfil = tipoPerfil;
		this.usuarios = usuarios;
	}

	public int getIdPerfil() {
		return idPerfil;
	}

	protected void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getTipoPerfil() {
		return tipoPerfil;
	}

	public void setTipoPerfil(String tipoPerfil) {
		this.tipoPerfil = tipoPerfil;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Set<UsuarioEntity> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<UsuarioEntity> usuarios) {
		this.usuarios = usuarios;
	}

}
