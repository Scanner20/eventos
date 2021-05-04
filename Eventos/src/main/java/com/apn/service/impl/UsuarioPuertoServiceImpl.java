package com.apn.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apn.model.Expositor;
import com.apn.model.UsuarioPuerto;
import com.apn.repository.UsuarioPuertoRepository;
import com.apn.service.UsuarioPuertoService;

@Service
public class UsuarioPuertoServiceImpl implements UsuarioPuertoService{
	
	
	Logger LOGGER = LoggerFactory.getLogger(UsuarioPuertoServiceImpl.class);
	
	@Autowired
	UsuarioPuertoRepository usuarioPuertoRepository;

	@Override
	public List<UsuarioPuerto> listaPuertos(String codigoPuerto) throws Exception {
		return usuarioPuertoRepository.listaPuertos(codigoPuerto);
	}


}
