package com.TPOO2.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.TPOO2.converters.LugarConverter;
import com.TPOO2.entities.LugarEntity;
import com.TPOO2.models.LugarModel;
import com.TPOO2.repositories.ILugarRepository;
import com.TPOO2.services.ILugarService;

@Service("lugarService")
public class LugarSevice implements ILugarService{

	@Autowired
	@Qualifier("lugarRepository")
	private ILugarRepository lugarRepository;
	
	

	@Autowired
	@Qualifier("lugarConverter")
	private LugarConverter lugarConverter;

	
	@Override
	public List<LugarModel> traerLugares() {
		List<LugarModel> models = new ArrayList<LugarModel>();
		for (LugarEntity lugar : lugarRepository.findAll()) {
			models.add(lugarConverter.entityToModel(lugar));
			}
		return models;
	}
}
