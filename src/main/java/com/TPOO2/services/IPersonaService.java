package com.TPOO2.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.TPOO2.models.PersonaModel;

@Service
public interface IPersonaService {

	public List<PersonaModel> traerPersonas();
	public PersonaModel insertOrUpdate(PersonaModel personaModel);
	public boolean remove(int id);
}
