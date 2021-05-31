package com.TPOO2.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.TPOO2.converters.PersonaConverter;
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
	
	
	
}
