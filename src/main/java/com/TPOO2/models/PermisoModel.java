package com.TPOO2.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public abstract class PermisoModel {

	protected int idPermiso;
	protected PersonaModel pedido;
	protected LocalDate fecha;
	protected Set<LugarModel> desdeHasta = new HashSet<LugarModel>();
	protected String fechaDesde;
	protected String fechaHasta;
	protected int salidaLlegada;
	
	public PermisoModel(int idPermiso, PersonaModel pedido, LocalDate fecha, Set<LugarModel> desdeHasta) {
		super();
		this.idPermiso = idPermiso;
		this.pedido = pedido;
		this.fecha = fecha;
		this.desdeHasta = desdeHasta;
	}
	
	public PermisoModel() {}

	public int getIdPermiso() {
		return idPermiso;
	}

	public void setIdPermiso(int idPermiso) {
		this.idPermiso = idPermiso;
	}

	public PersonaModel getPedido() {
		return pedido;
	}

	public void setPedido(PersonaModel pedido) {
		this.pedido = pedido;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Set<LugarModel> getDesdeHasta() {
		return desdeHasta;
	}

	public void setDesdeHasta(Set<LugarModel> desdeHasta) {
		this.desdeHasta = desdeHasta;
	}


	public String getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(String fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public String getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(String fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
	

	public int getSalidaLlegada() {
		return salidaLlegada;
	}

	public void setSalidaLlegada(int salidaLlegada) {
		this.salidaLlegada = salidaLlegada;
	}

	@Override
	public String toString() {
		return "PermisoModel [idPermiso=" + idPermiso + ", pedido=" + pedido + ", fecha=" + fecha + ", desdeHasta="
				+ desdeHasta + "]";
	}
	
	
	
}
