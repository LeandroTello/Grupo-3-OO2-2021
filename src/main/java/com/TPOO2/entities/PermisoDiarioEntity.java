package com.TPOO2.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "permisoDiario")
@PrimaryKeyJoinColumn(referencedColumnName="idPermiso")
public class PermisoDiarioEntity extends PermisoEntity {

	@Column(name = "motivo", nullable = false)
	private String motivo;

	public PermisoDiarioEntity(int idPermiso, PersonaEntity pedido, LocalDate fecha, Set<LugarEntity> desdeHasta,
			String motivo) {
		super(idPermiso, pedido, fecha, desdeHasta);
		this.motivo = motivo;
	}
	public PermisoDiarioEntity() {}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	@Override
	public String toString() {
		return "PermisoDiario [motivo=" + motivo + "]";
	}
	
	
}
