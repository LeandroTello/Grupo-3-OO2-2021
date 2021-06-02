package com.TPOO2.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.TPOO2.entities.PermisoPeriodoEntity;
import com.TPOO2.models.PermisoPeriodoModel;

@Component("permisoPeriodoConverter")
public class PermisoPeriodoConverter {

	@Autowired
	@Qualifier("personaConverter")
	private PersonaConverter personaConverter;

	@Autowired
	@Qualifier("lugarConverter")
	private LugarConverter lugarConverter;

	@Autowired
	@Qualifier("rodadoConverter")
	private RodadoConverter rodadoConverter;

	public PermisoPeriodoModel entityToModel(PermisoPeriodoEntity permiso) {
		return new PermisoPeriodoModel(permiso.getIdPermiso(), personaConverter.entityToModel(permiso.getPedido()),
				permiso.getFecha(), lugarConverter.entityToModel(permiso.getDesdeHasta()), permiso.getCantDias(),
				permiso.isVacaciones(), rodadoConverter.entityToModel(permiso.getRodado()));
	}

	public PermisoPeriodoEntity modelToEntity(PermisoPeriodoModel permiso) {
		return new PermisoPeriodoEntity(permiso.getIdPermiso(), personaConverter.modelToEntity(permiso.getPedido()),
				permiso.getFecha(), lugarConverter.modelToEntity(permiso.getDesdeHasta()), permiso.getCantDias(),
				permiso.isVacaciones(), rodadoConverter.modelToEntity(permiso.getRodado()));
	}
	
}
