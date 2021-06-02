package com.TPOO2.models;

import java.time.LocalDate;
import java.util.Set;

public class PermisoDiarioModel extends PermisoModel {

	private String motivo;
	private int idDesde;
	private int idHasta;
	private long dni;
	private String fechaInicial;

	public PermisoDiarioModel(int idPermiso, PersonaModel pedido, LocalDate fecha, Set<LugarModel> desdeHasta,
			String motivo) {
		super(idPermiso, pedido, fecha, desdeHasta);
		this.motivo = motivo;
	}

	public PermisoDiarioModel() {
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	
	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}
	
	

	public String getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(String fechaInicial) {
		this.fechaInicial = fechaInicial;
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

	@Override
	public String toString() {
		return "PermisoDiarioModel [motivo=" + motivo + "]";
	}
	
}
