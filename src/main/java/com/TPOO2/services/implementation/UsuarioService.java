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

import com.TPOO2.converters.UsuarioConverter;
import com.TPOO2.entities.UsuarioEntity;
import com.TPOO2.models.UsuarioModel;
import com.TPOO2.repositories.IUsuarioRepository;
import com.TPOO2.services.IUsuarioService;
import com.unla.ejemplo1.entities.UserRole;

@Service("usuarioService")
public class UsuarioService implements IUsuarioService, UserDetailsService{
	@Autowired
	@Qualifier("usuarioRepository")
	private IUsuarioRepository usuarioRepository;

	@Autowired
	@Qualifier("usuarioConverter")
	private UsuarioConverter usuarioConverter;

	@Override
	public List<UsuarioEntity> getAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public UsuarioModel insertOrUpdate(UsuarioModel usuarioModel) {
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

//	@Override
//	public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
//		com.TPOO2.entities.UsuarioEntity usuario = usuarioRepository.traerPorNombre(nombreUsuario);
//		return this.buildUser(usuario, this.buildGrantedAuthorities(usuario.getPerfil()));
//	}
//
//	private User buildUser(com.TPOO2.entities.User user, List<GrantedAuthority> grantedAuthorities) {
//		return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, grantedAuthorities); 
																															// accountNonExpired,credentials
																															// Non,
																															// Expired,
																															// //
																															// accountNonLocked
	}

//	private List<GrantedAuthority> buildGrantedAuthorities(Set<UserRole> userRoles) {
//		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
//		for (UserRole userRole : userRoles) {
//			grantedAuthorities.add(new SimpleGrantedAuthority(userRole.getRole()));
//
//		}
//
//		return new ArrayList<GrantedAuthority>(grantedAuthorities);
//	}

}
