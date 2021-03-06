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
	public UsuarioModel deleteUsuario(UsuarioModel usuarioModel);
	public List<UsuarioModel> traerUsuarios();
	public UsuarioEntity traerUsuarioEntityPorId(int id);
	public UsuarioModel traerUsuarioModelPorId(int id);
	public List<UsuarioEntity> traerUsuariosParaPDF();
}
