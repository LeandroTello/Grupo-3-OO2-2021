package com.TPOO2.converters;

import org.springframework.stereotype.Component;

import com.TPOO2.entities.RodadoEntity;
import com.TPOO2.models.RodadoModel;

@Component("rodadoConverter")
public class RodadoConverter {

	public RodadoModel entityToModel(RodadoEntity rodado) {
		return new RodadoModel(rodado.getIdRodado(),rodado.getDominio(),rodado.getVehiculo());
	}
	
	public RodadoEntity modelToEntity(RodadoModel rodado) {
		return new RodadoEntity(rodado.getIdRodado(),rodado.getDominio(),rodado.getVehiculo());
	}
}
