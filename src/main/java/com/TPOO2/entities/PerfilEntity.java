package com.TPOO2.entities;

import java.time.LocalDateTime;
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
import javax.persistence.UniqueConstraint;
import com.TPOO2.entities.UsuarioEntity;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "perfil"/*,uniqueConstraints = @UniqueConstraint(columnNames= {"permiso","usuarios"})*/)
public class PerfilEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPerfil;

	
	@Column(name = "tipoPerfil")
	private String tipoPerfil;

	@Column(name = "activo")
	private boolean activo;

	@Column(name = "createdat")
	@CreationTimestamp
	private LocalDateTime createdAt;

	@Column(name = "updatedat")
	private LocalDateTime updatedAt;

	@OneToMany(fetch = FetchType.LAZY,mappedBy = "perfil")
	private Set<UsuarioEntity> usuarios = new HashSet<UsuarioEntity>();

	public PerfilEntity() {}

	

	public PerfilEntity(int idPerfil,String tipoPerfil, boolean activo, Set<UsuarioEntity> usuarios) {
		super();
		this.setIdPerfil(idPerfil);
		this.tipoPerfil = tipoPerfil;
		this.activo = activo;
		this.usuarios = usuarios;
	}
	public PerfilEntity(String tipoPerfil, boolean activo, Set<UsuarioEntity> usuarios) {
		super();
		this.tipoPerfil = tipoPerfil;
		this.activo = activo;
		this.usuarios = usuarios;
	}


	public String getTipoPerfil() {
		return tipoPerfil;
	}



	public void setTipoPerfil(String tipoPerfil) {
		this.tipoPerfil = tipoPerfil;
	}



	public int getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}


	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Set<UsuarioEntity> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<UsuarioEntity> usuarios) {
		this.usuarios = usuarios;
	}

}
