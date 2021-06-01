package com.TPOO2.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.TPOO2.entities.RodadoEntity;
@Repository("rodadoRepository")

public interface IRodadoRepository extends JpaRepository<RodadoEntity, Serializable>{

	@Query("SELECT p FROM RodadoEntity p where p.idRodado=(:idRodado)")
	public abstract RodadoEntity traerRodadoEntityPorId(@Param("idRodado")int idRodado);
	@Query("SELECT p FROM RodadoEntity p where p.dominio=(:dominio)")
	public abstract RodadoEntity traerRodadoEntityPorDominio(@Param("dominio")String dominio);
}