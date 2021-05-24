package com.TPOO2.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.TPOO2.entities.UsuarioEntity;
import com.TPOO2.models.UsuarioModel;

@Service
public interface IUsuarioService {
	public List<UsuarioEntity> getAll();
	public UsuarioModel insertOrUpdate(UsuarioModel usuarioModel);
	public boolean remove(int id);
}
