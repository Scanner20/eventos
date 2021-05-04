package com.apn.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apn.model.LugarTuristico;
import com.apn.repository.LugarTuristicoRepository;
import com.apn.service.LugarTuristicoService;

@Service
public class LugarTuristicoServiceImpl implements LugarTuristicoService{
	
	
	Logger LOGGER = LoggerFactory.getLogger(LugarTuristicoServiceImpl.class);
	
	@Autowired
	LugarTuristicoRepository lugarturisticoRepository;

	@Override
	public List<LugarTuristico> loginUsuario(String id) throws Exception {
		return lugarturisticoRepository.loginUsuario(id);
	}


}
