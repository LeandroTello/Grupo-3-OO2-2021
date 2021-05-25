package com.TPOO2.services.implementation;

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
	public List<PerfilEntity> getAll() {
		return perfilRepository.findAll();
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

}
