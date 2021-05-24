package com.TPOO2.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="perfil")
public class PerfilEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPerfil;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="activo")
	private boolean activo;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="usuario")
	private Set<UsuarioEntity> usuarios = new HashSet<UsuarioEntity>();

	public PerfilEntity () {}

	public int getIdPerfil() {
		return idPerfil;
	}

	protected void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
