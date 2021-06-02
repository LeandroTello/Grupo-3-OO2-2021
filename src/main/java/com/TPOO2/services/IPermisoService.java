package com.TPOO2.services;

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
}
