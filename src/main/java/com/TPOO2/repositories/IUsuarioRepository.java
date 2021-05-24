package com.TPOO2.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.TPOO2.entities.UsuarioEntity;

@Repository("usuarioRepository")
public interface IUsuarioRepository extends JpaRepository<UsuarioEntity, Serializable>{
	/*public abstract UsuarioEntity traerNombre(String nombre);
	public abstract UsuarioEntity traerApellido(String apellido);*/
	
	@Query("SELECT u FROM UsuarioEntity u JOIN FETCH u.perfil WHERE u.nombreUsuario = (:nombreUsuario)")
	public abstract UsuarioEntity traerPorNombre(@Param("nombreUsuario")String nombreUsuario);
}
