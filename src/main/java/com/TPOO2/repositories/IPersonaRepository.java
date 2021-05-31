package com.TPOO2.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.TPOO2.entities.PersonaEntity;

@Repository("personaRepository")

public interface IPersonaRepository extends JpaRepository<PersonaEntity, Serializable>{

	@Query("SELECT p FROM PersonaEntity p where p.dni=(:dni)")
	public abstract PersonaEntity traerPersonaEntityPorDni(@Param("dni")long dni);
}
