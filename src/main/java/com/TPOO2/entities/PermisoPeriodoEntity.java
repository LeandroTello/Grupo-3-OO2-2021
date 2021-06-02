package com.TPOO2.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "permisoPeriodo")
@PrimaryKeyJoinColumn(referencedColumnName="idPermiso")
public class PermisoPeriodoEntity extends PermisoEntity {

	@Column(name = "cantDias", nullable = false)
	private int cantDias;
	
	@Column(name = "vacaciones", nullable = false)
	private boolean vacaciones;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rodado_id", nullable = false)	
	private RodadoEntity rodado;

	public PermisoPeriodoEntity(int idPermiso, PersonaEntity pedido, LocalDate fecha, Set<LugarEntity> desdeHasta,
			int cantDias, boolean vacaciones, RodadoEntity rodado) {
		super(idPermiso, pedido, fecha, desdeHasta);
		this.cantDias = cantDias;
		this.vacaciones = vacaciones;
		this.rodado = rodado;
	}
	
	public PermisoPeriodoEntity() {
		super();
	}

	public int getCantDias() {
		return cantDias;
	}

	public void setCantDias(int cantDias) {
		this.cantDias = cantDias;
	}

	public boolean isVacaciones() {
		return vacaciones;
	}

	public void setVacaciones(boolean vacaciones) {
		this.vacaciones = vacaciones;
	}

	public RodadoEntity getRodado() {
		return rodado;
	}

	public void setRodado(RodadoEntity rodado) {
		this.rodado = rodado;
	}

	@Override
	public String toString() {
		return "PermisoPeriodo [cantDias=" + cantDias + ", vacaciones=" + vacaciones + ", rodado=" + rodado + "]";
	}
	
	
}
