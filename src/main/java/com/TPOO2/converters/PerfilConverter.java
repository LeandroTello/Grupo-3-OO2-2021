package com.TPOO2.converters;

import org.springframework.stereotype.Component;

import com.TPOO2.entities.PerfilEntity;
import com.TPOO2.entities.UsuarioEntity;
import com.TPOO2.models.PerfilModel;
import com.TPOO2.models.UsuarioModel;

@Component("perfilConverter")
public class PerfilConverter {
	
	public PerfilModel entityToModel(PerfilEntity perfilEntity) {
		return new PerfilModel(perfilEntity.getTipoPerfil(), perfilEntity.getUsuarios());
	}

	public PerfilEntity modelToEntity(PerfilModel perfilModel) {
		return new PerfilEntity(perfilModel.getTipoPerfil(),perfilModel.isActivo(), perfilModel.getUsuarios());
	}
}
