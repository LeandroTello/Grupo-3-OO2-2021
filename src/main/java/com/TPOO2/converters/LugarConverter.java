package com.TPOO2.converters;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.TPOO2.entities.LugarEntity;
import com.TPOO2.models.LugarModel;

@Component("lugarConverter")

public class LugarConverter {

	public LugarModel entityToModel(LugarEntity lugar) {
		return new LugarModel(lugar.getIdLugar(), lugar.getLugar(), lugar.getCodigoPostal());
	}

	public LugarEntity modelToEntity(LugarModel lugar) {
		return new LugarEntity(lugar.getIdLugar(), lugar.getLugar(), lugar.getCodigoPostal());
	}

	public Set<LugarModel> entityToModel(Set<LugarEntity> lugares) {
		Set<LugarModel> models = new HashSet<LugarModel>();

		for (LugarEntity lugar : lugares) {
			models.add(this.entityToModel(lugar));

		}
		return models;
	}

	public Set<LugarEntity> modelToEntity(Set<LugarModel> lugares) {
		Set<LugarEntity> models = new HashSet<LugarEntity>();

		for (LugarModel lugar : lugares) {
			models.add(this.modelToEntity(lugar));

		}
		return models;
	}

}
