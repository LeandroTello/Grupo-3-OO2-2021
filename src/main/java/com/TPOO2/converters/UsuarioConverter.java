package com.TPOO2.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.TPOO2.entities.PerfilEntity;
import com.TPOO2.entities.UsuarioEntity;
import com.TPOO2.models.UsuarioModel;
import com.TPOO2.repositories.IPerfilRepository;

@Component("usuarioConverter")
public class UsuarioConverter {
	@Autowired
	@Qualifier("perfilRepository")
	private IPerfilRepository perfilRepository;

	public UsuarioModel entityToModel(UsuarioEntity usuarioEntity) {
		return new UsuarioModel(usuarioEntity.getNombre(), usuarioEntity.getApellido(), usuarioEntity.getTipo(),
				usuarioEntity.getDni(), usuarioEntity.getEmail(), usuarioEntity.getNombreUsuario(),
				usuarioEntity.getPass());
	}

	public UsuarioEntity modelToEntity(UsuarioModel usuarioModel) {
		return new UsuarioEntity(usuarioModel.getNombre(), usuarioModel.getApellido(), usuarioModel.getTipo(),
				usuarioModel.getDni(), usuarioModel.getEmail(), usuarioModel.getNombreUsuario(),
				usuarioModel.getPass(),usuarioModel.isActivo(),perfilRepository.traerPorID(usuarioModel.getIdPerfil()));
	}
}
