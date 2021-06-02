package com.TPOO2.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "permiso")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PermisoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int idPermiso;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pedido_id", nullable = false)	
	protected PersonaEntity pedido;
	
	@Column(name = "fecha", nullable = false)
	protected LocalDate fecha;
	
	@JoinTable(
			name = "permisoxlugar",
			joinColumns = @JoinColumn(name="FK_permiso", nullable = false),
			inverseJoinColumns = @JoinColumn(name="FK_lugar", nullable = false)
	)
	@ManyToMany(cascade = CascadeType.ALL)
	protected Set<LugarEntity> desdeHasta;
	
	
	public PermisoEntity(int idPermiso, PersonaEntity pedido, LocalDate fecha, Set<LugarEntity> desdeHasta) {
		super();
		this.idPermiso = idPermiso;
		this.pedido = pedido;
		this.fecha = fecha;
		this.desdeHasta = desdeHasta;
	}
	
	public PermisoEntity() {}

	public int getIdPermiso() {
		return idPermiso;
	}

	public void setIdPermiso(int idPermiso) {
		this.idPermiso = idPermiso;
	}

	public PersonaEntity getPedido() {
		return pedido;
	}

	public void setPedido(PersonaEntity pedido) {
		this.pedido = pedido;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Set<LugarEntity> getDesdeHasta() {
		return desdeHasta;
	}

	public void setDesdeHasta(Set<LugarEntity> desdeHasta) {
		this.desdeHasta = desdeHasta;
	}

	@Override
	public String toString() {
		return "PermisoEntity [idPermiso=" + idPermiso + ", pedido=" + pedido + ", fecha=" + fecha + ", desdeHasta="
				+ desdeHasta + "]";
	}
	
}
