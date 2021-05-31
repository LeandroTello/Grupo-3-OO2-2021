package com.TPOO2.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.TPOO2.converters.PersonaConverter;
import com.TPOO2.entities.PersonaEntity;
import com.TPOO2.models.PersonaModel;
import com.TPOO2.repositories.IPersonaRepository;
import com.TPOO2.services.IPersonaService;

@Service("personaService")
public class PersonaService implements IPersonaService {

	
	@Autowired
	@Qualifier("personaRepository")
	private IPersonaRepository personaRepository;

	@Autowired
	@Qualifier("personaConverter")
	private PersonaConverter personaConverter;
	
	@Override
	public List<PersonaEntity> traerPersonas() {
		List<PersonaEntity> personas = personaRepository.findAll();		
		return personas;
	}
	
	@Override
	public PersonaModel insertOrUpdate(PersonaModel personaModel) {

		PersonaEntity personaEntity = personaRepository.save(personaConverter.modelToEntity(personaModel));
		return personaConverter.entityToModel(personaEntity);
	}
	
	@Override
	public boolean remove(int id) {
		try {
			personaRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
