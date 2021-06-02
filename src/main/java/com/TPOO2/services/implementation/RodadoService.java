package com.TPOO2.services.implementation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.TPOO2.converters.RodadoConverter;
import com.TPOO2.entities.RodadoEntity;
import com.TPOO2.models.RodadoModel;
import com.TPOO2.repositories.IRodadoRepository;
import com.TPOO2.services.IRodadoService;

@Service("rodadoService")

public class RodadoService implements IRodadoService{
	
	@Autowired
	@Qualifier("rodadoRepository")
	private IRodadoRepository rodadoRepository;

	@Autowired
	@Qualifier("rodadoConverter")
	private RodadoConverter rodadoConverter;

	@Override
	public List<RodadoEntity> traerRodados() {
		List<RodadoEntity> rodados = rodadoRepository.findAll();
		return rodados;
	}

	@Override
	public RodadoModel insertOrUpdate(RodadoModel rodadoModel) {
		if(this.existeDominio(rodadoModel.getDominio())!=null) {
			rodadoModel = rodadoConverter.entityToModel(this.existeDominio(rodadoModel.getDominio()));
		}
		RodadoEntity rodadoEntity = rodadoRepository.save(rodadoConverter.modelToEntity(rodadoModel));
		return rodadoConverter.entityToModel(rodadoEntity);
	}
	
	public RodadoEntity existeDominio(String dominio) {
		return  rodadoRepository.traerRodadoEntityPorDominio(dominio);
	}	
	

	@Override
	public boolean remove(int id) {
		try {
			rodadoRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
