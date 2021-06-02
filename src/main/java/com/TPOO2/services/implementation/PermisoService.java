package com.TPOO2.services.implementation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.TPOO2.converters.LugarConverter;
import com.TPOO2.converters.PermisoDiarioConverter;
import com.TPOO2.converters.PermisoPeriodoConverter;
import com.TPOO2.converters.PersonaConverter;
import com.TPOO2.converters.RodadoConverter;
import com.TPOO2.entities.PermisoDiarioEntity;
import com.TPOO2.entities.PermisoEntity;
import com.TPOO2.entities.PermisoPeriodoEntity;
import com.TPOO2.models.PermisoDiarioModel;
import com.TPOO2.models.PermisoModel;
import com.TPOO2.models.PermisoPeriodoModel;
import com.TPOO2.repositories.ILugarRepository;
import com.TPOO2.repositories.IPermisoRepository;
import com.TPOO2.repositories.IPersonaRepository;
import com.TPOO2.repositories.IRodadoRepository;
import com.TPOO2.services.IPermisoService;

@Service("permisoService")
public class PermisoService implements IPermisoService {
	
	@Autowired
	@Qualifier("lugarRepository")
	private ILugarRepository lugarRepository;
	
	@Autowired
	@Qualifier("rodadoRepository")
	private IRodadoRepository rodadoRepository;


	@Autowired
	@Qualifier("permisoRepository")
	private IPermisoRepository permisoRepository;
	
	@Autowired
	@Qualifier("personaRepository")
	private IPersonaRepository personaRepository;
	
	@Autowired
	@Qualifier("personaConverter")
	private PersonaConverter personaConverter;
	
	@Autowired
	@Qualifier("lugarConverter")
	private LugarConverter lugarConverter;
	
	@Autowired
	@Qualifier("rodadoConverter")
	private RodadoConverter rodadoConverter;

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

		PermisoDiarioEntity permisoDiarioEntity = permisoRepository.save(permisoDiarioConverter.modelToEntity(permisoDiarioModel));
		return permisoDiarioConverter.entityToModel(permisoDiarioEntity);

	}

	public PermisoPeriodoModel insertOrUpdate(PermisoPeriodoModel permisoPeriodoModel) {
		permisoPeriodoModel.setFecha(LocalDate.now());
		permisoPeriodoModel.setPedido(personaConverter.entityToModel(personaRepository.traerPersonaEntityPorDni(permisoPeriodoModel.getDni())));
		permisoPeriodoModel.getDesdeHasta().add(lugarConverter.entityToModel(lugarRepository.traerLugarEntityPorId(permisoPeriodoModel.getIdDesde())));
		permisoPeriodoModel.getDesdeHasta().add(lugarConverter.entityToModel(lugarRepository.traerLugarEntityPorId(permisoPeriodoModel.getIdHasta())));
		permisoPeriodoModel.setRodado(rodadoConverter.entityToModel(rodadoRepository.traerRodadoEntityPorDominio(permisoPeriodoModel.getDominio())));
		PermisoPeriodoEntity permisoPeriodoEntity =permisoRepository.save(permisoPeriodoConverter.modelToEntity(permisoPeriodoModel));
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