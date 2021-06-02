package com.TPOO2.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TPOO2.entities.PermisoEntity;

@Repository("permisoRepository")
public interface IPermisoRepository extends JpaRepository<PermisoEntity, Serializable> {

	
}
