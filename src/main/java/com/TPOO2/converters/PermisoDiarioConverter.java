package com.TPOO2.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.TPOO2.entities.PermisoDiarioEntity;
import com.TPOO2.models.PermisoDiarioModel;

@Component("permisoDiarioConverter")
public class PermisoDiarioConverter {

    @Autowired
    @Qualifier("personaConverter")
    private PersonaConverter personaConverter;
    
    @Autowired
    @Qualifier("lugarConverter")
    private LugarConverter lugarConverter;

    public PermisoDiarioModel entityToModel(PermisoDiarioEntity permiso) {
        return new PermisoDiarioModel(permiso.getIdPermiso(),personaConverter.entityToModel(permiso.getPedido()),permiso.getFecha(),lugarConverter.entityToModel(permiso.getDesdeHasta()),permiso.getMotivo());
    }
    public PermisoDiarioEntity modelToEntity(PermisoDiarioModel permiso) {
        return new PermisoDiarioEntity(permiso.getIdPermiso(),personaConverter.modelToEntity(permiso.getPedido()),permiso.getFecha(),lugarConverter.modelToEntity(permiso.getDesdeHasta()),permiso.getMotivo());
    } 

}