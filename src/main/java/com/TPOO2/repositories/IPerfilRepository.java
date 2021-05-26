package com.TPOO2.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.TPOO2.entities.PerfilEntity;
import com.TPOO2.entities.UsuarioEntity;

@Repository("perfilRepository")
public interface IPerfilRepository extends JpaRepository<PerfilEntity, Serializable> {
	
	@Query("SELECT p FROM PerfilEntity p where p.idPerfil=(:id)")
	public abstract PerfilEntity traerPorID(@Param("id")int id);

	
}
