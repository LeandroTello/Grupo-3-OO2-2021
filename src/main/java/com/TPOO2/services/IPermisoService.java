package com.TPOO2.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.TPOO2.models.PermisoDiarioModel;
import com.TPOO2.models.PermisoModel;
import com.TPOO2.models.PermisoPeriodoModel;

@Service
public interface IPermisoService {

	public List<PermisoModel> traerPermisos();
	public PermisoPeriodoModel insertOrUpdate(PermisoPeriodoModel permisoPeriodoModel);
	public PermisoDiarioModel insertOrUpdate(PermisoDiarioModel permisoDiarioModel);
	public boolean remove(int id);
	public Set<PermisoPeriodoModel> traerPermisosPorDominio(String dominio);
	public Set<PermisoDiarioModel> traerPermisosDiarosPorDNI(long dni);
	public Set<PermisoPeriodoModel> traerPermisosPeriodoPorDNI(long dni);
	public Set<PermisoDiarioModel> traerPermisosDiarosPorFecha(LocalDate desde,LocalDate hasta);
	public Set<PermisoPeriodoModel> traerPermisosPeriodoPorFecha(LocalDate desde,LocalDate hasta);
	public Set<PermisoDiarioModel> traerPermisosDiarosPorFechaYLugar(LocalDate desde,LocalDate hasta,int salidaLlegada,int idLocalidad);
	public Set<PermisoPeriodoModel> traerPermisosPeriodoPorFechaYLugar(LocalDate desde,LocalDate hasta,int salidaLlegada,int idLocalidad);
	public String crearQrPorId(int idPermiso);
}
