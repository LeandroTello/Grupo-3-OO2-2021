package com.TPOO2.services.implementation;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		permisoDiarioModel.setFecha(LocalDate.parse(permisoDiarioModel.getFechaInicial()));
		permisoDiarioModel.setPedido(personaConverter
				.entityToModel(personaRepository.traerPersonaEntityPorDni(permisoDiarioModel.getDni())));
		permisoDiarioModel.getDesdeHasta().add(
				lugarConverter.entityToModel(lugarRepository.traerLugarEntityPorId(permisoDiarioModel.getIdDesde())));
		permisoDiarioModel.getDesdeHasta().add(
				lugarConverter.entityToModel(lugarRepository.traerLugarEntityPorId(permisoDiarioModel.getIdHasta())));
		PermisoDiarioEntity permisoDiarioEntity = permisoRepository
				.save(permisoDiarioConverter.modelToEntity(permisoDiarioModel));
		return permisoDiarioConverter.entityToModel(permisoDiarioEntity);

	}

	public PermisoPeriodoModel insertOrUpdate(PermisoPeriodoModel permisoPeriodoModel) {
		permisoPeriodoModel.setFecha(LocalDate.parse(permisoPeriodoModel.getFechaInicial()));
		permisoPeriodoModel.setPedido(personaConverter
				.entityToModel(personaRepository.traerPersonaEntityPorDni(permisoPeriodoModel.getDni())));
		permisoPeriodoModel.getDesdeHasta().add(
				lugarConverter.entityToModel(lugarRepository.traerLugarEntityPorId(permisoPeriodoModel.getIdDesde())));
		permisoPeriodoModel.getDesdeHasta().add(
				lugarConverter.entityToModel(lugarRepository.traerLugarEntityPorId(permisoPeriodoModel.getIdHasta())));
		permisoPeriodoModel.setRodado(rodadoConverter
				.entityToModel(rodadoRepository.traerRodadoEntityPorDominio(permisoPeriodoModel.getDominio())));
		PermisoPeriodoEntity permisoPeriodoEntity = permisoRepository
				.save(permisoPeriodoConverter.modelToEntity(permisoPeriodoModel));
		return permisoPeriodoConverter.entityToModel(permisoPeriodoEntity);

	}

	public Set<PermisoPeriodoModel> traerPermisosPorDominio(String dominio) {
		Set<PermisoPeriodoModel> models = new HashSet<PermisoPeriodoModel>();
		for (PermisoPeriodoEntity permiso : permisoRepository.traerPermisosEntityPorDominio(dominio)) {
			models.add(permisoPeriodoConverter.entityToModel((PermisoPeriodoEntity) permiso));
		}
		return models;
	}

	public boolean remove(int id) {
		try {
			permisoRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Set<PermisoDiarioModel> traerPermisosDiarosPorDNI(long dni) {
		Set<PermisoDiarioModel> models = new HashSet<PermisoDiarioModel>();
		for (PermisoDiarioEntity permiso : permisoRepository.traerPermisosDiarioPorDNI(dni)) {
			if (permiso.getFecha().isAfter(LocalDate.now()) || permiso.getFecha().isEqual(LocalDate.now())) {
				models.add(permisoDiarioConverter.entityToModel(permiso));
			}
		}
		return models;
	}

	@Override
	public Set<PermisoPeriodoModel> traerPermisosPeriodoPorDNI(long dni) {
		Set<PermisoPeriodoModel> models = new HashSet<PermisoPeriodoModel>();
		for (PermisoPeriodoEntity permiso : permisoRepository.traerPermisosPeriodoPorDNI(dni)) {
			if (permiso.getFecha().plusDays(permiso.getCantDias()).isAfter(LocalDate.now())
					|| permiso.getFecha().plusDays(permiso.getCantDias()).isEqual(LocalDate.now())) {
				models.add(permisoPeriodoConverter.entityToModel(permiso));
			}
		}
		return models;
	}

}
