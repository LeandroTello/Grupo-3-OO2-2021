package com.TPOO2.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.TPOO2.entities.UsuarioEntity;

@Repository("usuarioRepository")
public interface IUsuarioRepository extends JpaRepository<UsuarioEntity, Serializable>{
	
	@Query("SELECT u FROM UsuarioEntity u JOIN FETCH u.perfil WHERE u.nombreUsuario = (:nombreUsuario)")
	public abstract UsuarioEntity traerPorNombre(@Param("nombreUsuario")String nombreUsuario);
	
	@Query("SELECT u FROM UsuarioEntity u JOIN FETCH u.perfil WHERE u.idUsuario = (:idUsuario)")
	public abstract UsuarioEntity traerUsuarioEntityPorId(@Param("idUsuario")int idUsuario);
}
