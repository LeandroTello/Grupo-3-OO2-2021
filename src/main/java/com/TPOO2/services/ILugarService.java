package com.TPOO2.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.TPOO2.models.LugarModel;

@Service
public interface ILugarService {
	public List<LugarModel> traerLugares();
}
