package com.TPOO2.models;

import java.time.LocalDate;
import java.util.Set;

public class PermisoPeriodoModel extends PermisoModel {

	private int cantDias;
	private boolean vacaciones;
	private RodadoModel rodado;
	private long dni;
	private String dominio;
	private int idDesde;
	private int idHasta;
	private String fechaInicial;
	
	public PermisoPeriodoModel(int idPermiso, PersonaModel pedido, LocalDate fecha, Set<LugarModel> desdeHasta,
			int cantDias, boolean vacaciones, RodadoModel rodado) {
		super(idPermiso, pedido, fecha, desdeHasta);
		this.cantDias = cantDias;
		this.vacaciones = vacaciones;
		this.rodado = rodado;
	}
	
	public PermisoPeriodoModel() {
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

	public RodadoModel getRodado() {
		return rodado;
	}

	public void setRodado(RodadoModel rodado) {
		this.rodado = rodado;
	}
	

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}
	

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}
	

	public int getIdDesde() {
		return idDesde;
	}

	public void setIdDesde(int idDesde) {
		this.idDesde = idDesde;
	}

	public int getIdHasta() {
		return idHasta;
	}

	public void setIdHasta(int idHasta) {
		this.idHasta = idHasta;
	}
	

	public String getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(String fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	@Override
	public String toString() {
		return "PermisoPeriodoModel [cantDias=" + cantDias + ", vacaciones=" + vacaciones + ", rodado=" + rodado + "]";
	}
	
}
