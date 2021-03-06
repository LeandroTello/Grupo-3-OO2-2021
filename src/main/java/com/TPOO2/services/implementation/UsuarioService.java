package com.TPOO2.services.implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.TPOO2.converters.PerfilConverter;
import com.TPOO2.converters.UsuarioConverter;
import com.TPOO2.entities.UsuarioEntity;
import com.TPOO2.funciones.Funciones;
import com.TPOO2.models.UsuarioModel;
import com.TPOO2.repositories.IPerfilRepository;
import com.TPOO2.repositories.IUsuarioRepository;
import com.TPOO2.services.IUsuarioService;
import com.TPOO2.entities.PerfilEntity;

@Service("usuarioService")
public class UsuarioService implements IUsuarioService, UserDetailsService {
	
	@Autowired
	@Qualifier("perfilRepository")
	private IPerfilRepository perfilRepository;
	@Autowired
	@Qualifier("usuarioRepository")
	private IUsuarioRepository usuarioRepository;

	@Autowired
	@Qualifier("usuarioConverter")
	private UsuarioConverter usuarioConverter;
	
	@Autowired
	@Qualifier("perfilConverter")
	private PerfilConverter perfilConverter;

	@Override
	public List<UsuarioEntity> getAll() {
		return usuarioRepository.findAll();
	}
	
	@Override
	public List<UsuarioEntity> traerUsuariosParaPDF(){
		List<UsuarioEntity> usuariosBuscados = new ArrayList<>();
		List<UsuarioModel> usuariosModel = this.traerUsuarios();
		int index=0;
		for(UsuarioModel usuario : usuariosModel) {
			if(usuario.isActivo()) {
				PerfilEntity perfil = perfilConverter.modelToEntity(usuario.getPerfil()); // Al convertirlo pierde el perfil 
                UsuarioEntity usuarioAAgregar = usuarioConverter.modelToEntity(usuario); // asi que lo guardo antes para setearlo.
                usuariosBuscados.add(usuarioAAgregar);
                usuariosBuscados.get(index).setPerfil(perfil);
			}
			index++;			
		}
		return usuariosBuscados;	
	}
	
	@Override
    public UsuarioEntity traerUsuarioEntityPorId(int id) {
        return usuarioRepository.traerUsuarioEntityPorId(id);
    }
	
	@Override
	public UsuarioModel traerUsuarioModelPorId(int id) {
	        return usuarioConverter.entityToModel(this.traerUsuarioEntityPorId(id));
	}
	
	@Override
	public List<UsuarioModel> traerUsuarios() {
		List<UsuarioModel> models = new ArrayList<UsuarioModel>();
		int index = 0;
		for (UsuarioEntity usuario : usuarioRepository.findAll()) {
			if(usuario.isActivo() && !usuario.getNombreUsuario().equals("invitado")) {
			models.add(usuarioConverter.entityToModel(usuario));
			models.get(index).setPerfil(perfilConverter.entityToModel(usuario.getPerfil()));
			index ++;
			}
		}		
		return models;
	}

	@Override
	public UsuarioModel insertOrUpdate(UsuarioModel usuarioModel) {	
		if(usuarioModel.getPass().length()<40)usuarioModel.setPass(Funciones.encriptarPass(usuarioModel.getPass()));
		UsuarioEntity usuarioEntity = usuarioRepository.save(usuarioConverter.modelToEntity(usuarioModel));
		return usuarioConverter.entityToModel(usuarioEntity);
	}

	@Override
	public boolean remove(int id) {
		try {
			usuarioRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public UsuarioModel deleteUsuario(UsuarioModel usuarioModel) {
		usuarioModel.setActivo(false);
		return this.insertOrUpdate(usuarioModel);
	}

	@Override
	public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
		UsuarioEntity usuario = usuarioRepository.traerPorNombre(nombreUsuario);
		return buildUser(usuario, buildGrantedAuthorities(usuario.getPerfil()));
	}

	private User buildUser(UsuarioEntity usuarioEntity, List<GrantedAuthority> grantedAuthorities) {
		return new User(usuarioEntity.getNombreUsuario(), usuarioEntity.getPass(), usuarioEntity.isActivo(), true, true,
				true, grantedAuthorities);
	}

	private List<GrantedAuthority> buildGrantedAuthorities(PerfilEntity perfilEntity) {
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		grantedAuthorities.add(new SimpleGrantedAuthority(perfilEntity.getTipoPerfil()));
		return new ArrayList<GrantedAuthority>(grantedAuthorities);
	}

}
