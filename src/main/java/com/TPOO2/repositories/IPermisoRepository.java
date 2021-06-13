package com.TPOO2.repositories;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.TPOO2.entities.PermisoDiarioEntity;
import com.TPOO2.entities.PermisoEntity;
import com.TPOO2.entities.PermisoPeriodoEntity;

@Repository("permisoRepository")
public interface IPermisoRepository extends JpaRepository<PermisoEntity, Serializable> {
	
	@Query("SELECT p FROM PermisoPeriodoEntity p inner join fetch p.rodado r where r.dominio=(:dominio) ORDER BY p.idPermiso desc")	
	public abstract Set<PermisoPeriodoEntity> traerPermisosEntityPorDominio(@Param("dominio")String dominio);
	
	@Query("SELECT p FROM PermisoDiarioEntity p inner join fetch p.pedido pe where pe.dni=(:dni)")	
	public abstract Set<PermisoDiarioEntity> traerPermisosDiarioPorDNI(@Param("dni")long dni);
	
	@Query("SELECT p FROM PermisoPeriodoEntity p inner join fetch p.pedido pe where pe.dni=(:dni)")	
	public abstract Set<PermisoPeriodoEntity> traerPermisosPeriodoPorDNI(@Param("dni")long dni);
	
	@Query("SELECT p FROM PermisoDiarioEntity p where p.fecha BETWEEN (:desde) AND (:hasta)")	
	public abstract Set<PermisoDiarioEntity> traerPermisosDiarioPorFecha(@Param("desde")LocalDate desde,@Param("hasta")LocalDate hasta);
	
	@Query("SELECT p FROM PermisoPeriodoEntity p where p.fecha <= (:hasta)")	
	public abstract Set<PermisoPeriodoEntity> traerPermisosPeriodoPorFecha(@Param("hasta")LocalDate hasta);
	
	@Query("SELECT p FROM PermisoEntity p where p.idPermiso = (:idPermiso)")
    public abstract PermisoEntity traerPermisoPorId(@Param("idPermiso")int idPermiso);

    @Query("SELECT p FROM PermisoPeriodoEntity p where p.idPermiso = (:idPermiso)")
    public abstract PermisoPeriodoEntity traerPermisoPeriodoPorId(@Param("idPermiso")int idPermiso);

    @Query("SELECT p FROM PermisoDiarioEntity p where p.idPermiso = (:idPermiso)")
    public abstract PermisoDiarioEntity traerPermisoDiarioPorId(@Param("idPermiso")int idPermiso);
}
