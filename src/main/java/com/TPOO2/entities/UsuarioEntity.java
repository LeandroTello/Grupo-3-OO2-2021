package com.TPOO2.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.TPOO2.enums.Tipo;

@Entity
@Table(name = "usuario")
public class UsuarioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "tipo")
	private Tipo tipo;

	@Column(name = "dni")
	private long dni;

	@Column(name = "email")
	private String email;

	@Column(name = "nombreUsuario", unique = true, nullable = false, length = 45)
	private String nombreUsuario;

	@Column(name = "pass", nullable = false, length = 100)
	private String pass;

	@Column(name = "activo")
	private boolean activo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "perfil_id", nullable = false)
	private PerfilEntity perfil;

	public UsuarioEntity() {
	}

	public UsuarioEntity(int idUsuario, String nombre, String apellido, Tipo tipo, long dni, String email, String nombreUsuario,
			String pass,boolean activo, PerfilEntity perfil) {
		super();
		this.setIdUsuario(idUsuario);
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipo = tipo;
		this.dni = dni;
		this.email = email;
		this.nombreUsuario = nombreUsuario;
		this.pass = pass;
		this.activo = activo;
		this.perfil = perfil;
	}
	public UsuarioEntity( String nombre, String apellido, Tipo tipo, long dni, String email, String nombreUsuario,
			String pass,boolean activo, PerfilEntity perfil) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipo = tipo;
		this.dni = dni;
		this.email = email;
		this.nombreUsuario = nombreUsuario;
		this.pass = pass;
		this.activo = activo;
		this.perfil = perfil;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public PerfilEntity getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilEntity perfil) {
		this.perfil = perfil;
	}

}
