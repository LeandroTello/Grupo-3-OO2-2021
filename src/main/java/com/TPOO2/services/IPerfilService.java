package com.TPOO2.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.TPOO2.models.PerfilModel;

@Service
public interface IPerfilService {
	
	public List<PerfilModel> traerPerfiles();
	public PerfilModel insertOrUpdate(PerfilModel perfilModel);
	public boolean remove(int id);

}
