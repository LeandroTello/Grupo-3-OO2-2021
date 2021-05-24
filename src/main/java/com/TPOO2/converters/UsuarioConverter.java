package com.TPOO2.converters;

import org.springframework.stereotype.Component;

import com.TPOO2.entities.UsuarioEntity;
import com.TPOO2.models.UsuarioModel;

@Component("usuarioConverter")
public class UsuarioConverter {

	public UsuarioModel entityToModel(UsuarioEntity usuarioEntity) {
		return new UsuarioModel(usuarioEntity.getNombre(), usuarioEntity.getApellido(), usuarioEntity.getTipo(),
				usuarioEntity.getDni(), usuarioEntity.getEmail(), usuarioEntity.getNombreUsuario(),
				usuarioEntity.getPass(), new PerfilConverter().entityToModel(usuarioEntity.getPerfil()));
	}

	public UsuarioEntity modelToEntity(UsuarioModel usuarioModel) {
		return new UsuarioEntity(usuarioModel.getNombre(), usuarioModel.getApellido(), usuarioModel.getTipo(),
				usuarioModel.getDni(), usuarioModel.getEmail(), usuarioModel.getNombreUsuario(),
				usuarioModel.getPass(), new PerfilConverter().modelToEntity(usuarioModel.getPerfil()));
	}
}
