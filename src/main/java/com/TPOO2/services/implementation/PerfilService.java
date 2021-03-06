package com.TPOO2.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.TPOO2.converters.PerfilConverter;
import com.TPOO2.entities.PerfilEntity;
import com.TPOO2.models.PerfilModel;
import com.TPOO2.repositories.IPerfilRepository;
import com.TPOO2.services.IPerfilService;

@Service("perfilService")
public class PerfilService implements IPerfilService {

	@Autowired
	@Qualifier("perfilRepository")
	private IPerfilRepository perfilRepository;

	@Autowired
	@Qualifier("perfilConverter")
	private PerfilConverter perfilConverter;
	
	@Override
	public List<PerfilModel> traerPerfiles() {
		List<PerfilModel> models = new ArrayList<PerfilModel>();
		for (PerfilEntity perfil : perfilRepository.findAll()) {
			if(perfil.isActivo() && !perfil.getTipoPerfil().equals("ROLE_GUEST")) {
			models.add(perfilConverter.entityToModel(perfil));
			}
		}
		return models;
	}
	
	public List<PerfilEntity>traerPerfilesParaPDF(){
	List<PerfilEntity> usuariosBuscados = new ArrayList<>();
	List<PerfilModel> usuariosModel = this.traerPerfiles();
	
	for(PerfilModel usuario : usuariosModel) {
		if(usuario.isActivo()) {
			PerfilEntity usuarioAAgregar = perfilConverter.modelToEntity(usuario);
			usuariosBuscados.add(usuarioAAgregar);
			
		}
		
	}
	return usuariosBuscados;
}


	@Override
	public PerfilModel insertOrUpdate(PerfilModel perfilModel) {
		PerfilEntity perfilEntity = perfilRepository.save(perfilConverter.modelToEntity(perfilModel));
		return perfilConverter.entityToModel(perfilEntity);
	}

	@Override
	public boolean remove(int id) {
		try {
			perfilRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public PerfilModel deletePerfil(PerfilModel perfilModel) {
		perfilModel.setActivo(false);
		return this.insertOrUpdate(perfilModel);
	}
	
	@Override
    public PerfilEntity traerPerfilEntityPorId(int id) {
        return perfilRepository.traerPerfilEntityPorId(id);
    }
	
	@Override
	public PerfilModel traerPerfilModelPorId(int id) {
	        return perfilConverter.entityToModel(this.traerPerfilEntityPorId(id));
	}

			

}
