package com.TPOO2.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.TPOO2.entities.LugarEntity;
import com.TPOO2.entities.PersonaEntity;

@Repository("lugarRepository")
public interface ILugarRepository extends JpaRepository<LugarEntity, Serializable> {
	
	@Query("SELECT l FROM LugarEntity l where l.idLugar=(:id)")
	public abstract LugarEntity traerLugarEntityPorId(@Param("id")int id);
}
