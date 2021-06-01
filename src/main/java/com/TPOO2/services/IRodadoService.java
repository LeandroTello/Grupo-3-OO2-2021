package com.TPOO2.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.TPOO2.entities.RodadoEntity;
import com.TPOO2.models.RodadoModel;

@Service()
public interface IRodadoService {
	public List<RodadoEntity> traerRodados();
	public RodadoModel insertOrUpdate(RodadoModel rodadoModel);
	public boolean remove(int id);
}
