package com.TPOO2.converters;

import org.springframework.stereotype.Component;

import com.TPOO2.entities.PersonaEntity;
import com.TPOO2.models.PersonaModel;

@Component("personaConverter")
public class PersonaConverter {

	public PersonaModel entityToModel(PersonaEntity persona) {
		return new PersonaModel(persona.getIdPersona(),persona.getNombre(),persona.getApellido(),persona.getDni()); 
	}
	
	public PersonaEntity modelToEntity(PersonaModel persona) {
		return new PersonaEntity(persona.getIdPersona(),persona.getNombre(),persona.getApellido(),persona.getDni());
	}
}
