package com.TPOO2.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.TPOO2.converters.PermisoDiarioConverter;
import com.TPOO2.converters.PermisoPeriodoConverter;
import com.TPOO2.entities.PermisoDiarioEntity;
import com.TPOO2.entities.PermisoEntity;
import com.TPOO2.entities.PermisoPeriodoEntity;
import com.TPOO2.models.PermisoDiarioModel;
import com.TPOO2.models.PermisoModel;
import com.TPOO2.models.PermisoPeriodoModel;
import com.TPOO2.repositories.IPermisoRepository;
import com.TPOO2.services.IPermisoService;

public class PermisoService implements IPermisoService {

	@Autowired
	@Qualifier("permisoRepository")
	private IPermisoRepository permisoRepository;

	@Autowired
	@Qualifier("permisoPeriodoConverter")
	private PermisoPeriodoConverter permisoPeriodoConverter;

	@Autowired
	@Qualifier("permisoDiarioConverter")
	private PermisoDiarioConverter permisoDiarioConverter;

	public List<PermisoModel> traerPermisos() {
		List<PermisoModel> models = new ArrayList<PermisoModel>();
		for (PermisoEntity permiso : permisoRepository.findAll()) {

			if (permiso instanceof PermisoPeriodoEntity) {
				models.add(permisoPeriodoConverter.entityToModel((PermisoPeriodoEntity) permiso));
			}

			else if (permiso instanceof PermisoDiarioEntity) {
				models.add(permisoDiarioConverter.entityToModel((PermisoDiarioEntity) permiso));
			}
		}
		return models;
	}

	public PermisoDiarioModel insertOrUpdate(PermisoDiarioModel permisoDiarioModel) {

		PermisoDiarioEntity permisoDiarioEntity = permisoRepository
				.save(permisoDiarioConverter.modelToEntity(permisoDiarioModel));
		return permisoDiarioConverter.entityToModel(permisoDiarioEntity);

	}

	public PermisoPeriodoModel insertOrUpdate(PermisoPeriodoModel permisoPeriodoModel) {

		PermisoPeriodoEntity permisoPeriodoEntity = permisoRepository
				.save(permisoPeriodoConverter.modelToEntity(permisoPeriodoModel));
		return permisoPeriodoConverter.entityToModel(permisoPeriodoEntity);

	}

	public boolean remove(int id) {
		try {
			permisoRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
